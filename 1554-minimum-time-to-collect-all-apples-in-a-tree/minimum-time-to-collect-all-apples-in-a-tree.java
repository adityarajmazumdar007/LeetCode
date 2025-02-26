class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++)
            adj.put(i , new ArrayList<>());
        
        for(int[] edge : edges){
            int parent = edge[0];
            int child = edge[1];
            adj.get(parent).add(child);
            adj.get(child).add(parent);
        }
        return getTime(adj, 0, -1, hasApple);
    }

    public int getTime(HashMap<Integer,ArrayList<Integer>> adj,
                       int curr, int parent, List<Boolean> hasApple){
         int time = 0;
         for(var child : adj.get(curr)){
             if(child == parent) continue;

             int timeFromChild = getTime(adj, child, curr, hasApple);
             if(timeFromChild > 0  || hasApple.get(child)){
                 time  += timeFromChild + 2;
             }
         }
         return time;
    }
}
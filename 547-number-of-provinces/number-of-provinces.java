class Solution {
    private static void  dfs(int node,int vis[],List<List<Integer>> ls){
        vis[node] = 1;
        for(Integer x : ls.get(node)) {
           if(vis[x] == 0) {
            dfs(x, vis, ls);
            }
            
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++){
            adjList.add(new ArrayList<>());
            for(int j = 0; j < isConnected[0].length; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adjList.get(i).add(j);
                }
            }
        }
        int count = 0;
        int vis[] = new int[n+1];
        Arrays.fill(vis,0);
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                count++;
                dfs(i, vis, adjList);
            }
        }
        
    return count;}
}
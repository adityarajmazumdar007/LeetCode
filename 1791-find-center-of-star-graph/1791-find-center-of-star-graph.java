class Solution {
    public int findCenter(int[][] edges) {
       HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();
        int totalEdges = edges.length;
        for ( int i =0; i <edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            mp.put(u,mp.getOrDefault(u,0) +1);
            mp.put(v,mp.getOrDefault(v,0) +1);
            if(mp.get(u) == totalEdges ) {
                return u;
            }
            if(mp.get(v) == totalEdges ) {
                return v;
            }
        }
        return -1;
    }
}
class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, Integer > mp = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            int edg[] = edges[i];
            int u = edg[0];
            int v = edg[1];
            mp.put(v, mp.getOrDefault(v, 0) +1);
            mp.put(u, mp.getOrDefault(u, 0) +1);
            if( mp.get(u) == edges.length) return u;
            if( mp.get(v) == edges.length) return v;
        }
        return -1;
    }
}
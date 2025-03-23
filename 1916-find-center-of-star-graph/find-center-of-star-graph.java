class Solution {
    public int findCenter(int[][] edges) {
        int indegree[] = new int[100000+1];
        for(int i = 0; i < edges.length; i++) {
            int edg[] = edges[i];
            int u = edg[0];
            int v = edg[1];
            indegree[u]++;
            indegree[v]++;
            if( indegree[u] == edges.length) return u;
            if( indegree[v] == edges.length) return v;
        }
        return -1;
    }
}
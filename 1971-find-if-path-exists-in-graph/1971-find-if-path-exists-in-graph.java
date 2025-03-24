import java.util.*;

class Solution {
    private static void dfs(ArrayList<ArrayList<Integer>> adj, int src, int[] vis) {
        vis[src] = 1;
        for (Integer x : adj.get(src)) {
            if (vis[x] == -1) {
                dfs(adj, x, vis);
            }
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate adjacency list
        for (int i = 0; i < edges.length; i++) {
            int edge1 = edges[i][0];
            int edge2 = edges[i][1];
            adj.get(edge1).add(edge2);
            adj.get(edge2).add(edge1);
        }

        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        dfs(adj, source, vis);
        
        // Check if destination is reachable from source
        return vis[destination] != -1;
    }
}
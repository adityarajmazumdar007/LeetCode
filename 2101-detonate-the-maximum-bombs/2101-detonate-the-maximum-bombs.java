import java.util.*;

class Solution {
    private long distanceSquared(int x1, int y1, int x2, int y2) {
        return (long) (x2 - x1) * (x2 - x1) + (long) (y2 - y1) * (y2 - y1);
    }

    private void dfs(int node, List<Integer>[] adj, boolean[] visited, int[] count) {
        visited[node] = true;
        count[0]++; // Increment count for each detonated bomb

        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, count);
            }
        }
    }

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<Integer>[] adj = new ArrayList[n];

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        // Build adjacency list (directed graph)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    long dist = distanceSquared(bombs[i][0], bombs[i][1], bombs[j][0], bombs[j][1]);
                    long radiusSquared = (long) bombs[i][2] * bombs[i][2];

                    if (dist <= radiusSquared) {
                        adj[i].add(j);
                    }
                }
            }
        }

        int maxDetonated = 0;

        // Perform DFS for each bomb as the starting point
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            int[] count = new int[1]; // Using array to modify value inside dfs
            dfs(i, adj, visited, count);
            maxDetonated = Math.max(maxDetonated, count[0]);
        }

        return maxDetonated;
    }
}

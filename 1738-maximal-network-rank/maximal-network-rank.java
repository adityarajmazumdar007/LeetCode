class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degree = new int[n]; // Store the degree (connections) of each node
        boolean[][] adj = new boolean[n][n]; // Adjacency matrix to check direct connections

        // Populate degree array and adjacency matrix
        for (int[] road : roads) {
            int u = road[0], v = road[1];
            degree[u]++;
            degree[v]++;
            adj[u][v] = true;
            adj[v][u] = true;
        }

        int maxRank = 0;

        // Iterate through all pairs (i, j)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = degree[i] + degree[j];

                // Reduce rank by 1 if nodes i and j are directly connected
                if (adj[i][j]) {
                    rank--;
                }

                maxRank = Math.max(maxRank, rank);
            }
        }

        return maxRank;
    }
}

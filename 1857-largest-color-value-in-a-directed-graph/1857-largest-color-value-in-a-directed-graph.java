
class Solution {
    /** Finds the largest color value of any valid path in the graph. */
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> adj = new ArrayList<>(n);
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list and calculate in-degrees
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }

        // DP table: dp[i][c] = max count of color c on path ending at node i
        int[][] dp = new int[n][26];
        Queue<Integer> queue = new LinkedList<>();

        // Initialize queue with nodes having in-degree 0
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int processedNodes = 0;
        int maxValue = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            processedNodes++;

            // Update count for the current node's color
            int colorIndexOfU = colors.charAt(u) - 'a';
            dp[u][colorIndexOfU]++;

            // Update the overall max value found so far
            maxValue = Math.max(maxValue, dp[u][colorIndexOfU]);

            // Process neighbors
            for (int v : adj.get(u)) {
                // Propagate max counts from u to v
                for (int c = 0; c < 26; c++) {
                    dp[v][c] = Math.max(dp[v][c], dp[u][c]);
                }

                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        // If not all nodes were processed, there's a cycle
        return processedNodes == n ? maxValue : -1;
    }
}
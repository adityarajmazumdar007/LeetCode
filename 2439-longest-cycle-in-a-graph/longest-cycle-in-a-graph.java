public class Solution {
    private int result = -1;

    private void dfs(int u, int[] edges, boolean[] visited, int[] dist, boolean[] inRecursion) {
        if (u != -1) {
            visited[u] = true;
            inRecursion[u] = true;

            int v = edges[u];

            if (v != -1 && !visited[v]) {
                dist[v] = dist[u] + 1;
                dfs(v, edges, visited, dist, inRecursion);
            } else if (v != -1 && inRecursion[v]) { // Cycle detected
                result = Math.max(result, dist[u] - dist[v] + 1);
            }

            inRecursion[u] = false;
        }
    }

    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        boolean[] inRecursion = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dist[i] = 1;
                dfs(i, edges, visited, dist, inRecursion);
            }
        }

        return result;
    }
}


class Solution {

    private void DFS(int u, Map<Integer, List<Integer>> adj, boolean[] visited) {
        visited[u] = true;

        for (int v : adj.getOrDefault(u, new ArrayList<>())) {
            if (!visited[v]) {
                DFS(v, adj, visited);
            }
        }
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) { // O(E)
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u); // v --> u
        }

        for (int u = 0; u < n; u++) {
            List<Integer> ancestors = new ArrayList<>();
            boolean[] visited = new boolean[n];
            DFS(u, adj, visited);

            for (int i = 0; i < n; i++) {
                if (i != u && visited[i]) {
                    ancestors.add(i);
                }
            }

            result.add(ancestors);
        }

        return result;
    }
}
import java.util.*;

class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        // Step 1: Build the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] result = new int[n]; // Result array
        boolean[] visited = new boolean[n]; // Visited array to track processed nodes

        dfs(0, adj, labels, result, visited); // Start DFS from node 0
        return result;
    }

    private int[] dfs(int node, List<List<Integer>> adj, String labels, int[] result, boolean[] visited) {
        int[] myCount = new int[26]; // Array to store character frequencies
        char myLabel = labels.charAt(node);
        myCount[myLabel - 'a'] = 1;

        visited[node] = true; // Mark the current node as visited

        for (int neighbor : adj.get(node)) {
            if (visited[neighbor]) continue; // Skip already visited nodes
            
            int[] childCount = dfs(neighbor, adj, labels, result, visited);

            // Merge child counts into current node's count
            for (int i = 0; i < 26; i++) {
                myCount[i] += childCount[i];
            }
        }

        result[node] = myCount[myLabel - 'a']; // Store the label count in the result array
        return myCount;
    }
}

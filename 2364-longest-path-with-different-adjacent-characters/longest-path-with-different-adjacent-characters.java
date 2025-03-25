import java.util.*;

class Solution {

    private int result;

    private int DFS(Map<Integer, List<Integer>> adj, int curr, int parent, String s) {
        int longest = 0;
        int secondLongest = 0;

        for (int child : adj.getOrDefault(curr, new ArrayList<>())) {
            if (child == parent) 
                continue;

            int childLongestLength = DFS(adj, child, curr, s);

            if (s.charAt(child) == s.charAt(curr)) 
                continue;

            if (childLongestLength > longest) {
                secondLongest = longest;
                longest = childLongestLength;
            } else if (childLongestLength > secondLongest) {
                secondLongest = childLongestLength;
            }
        }

        int includeCurrentNode = longest + 1; // Include current node
        int fullPath = longest + secondLongest + 1; // Longest valid path in the subtree

        result = Math.max(result, fullPath);

        return includeCurrentNode;
    }

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        result = 0;
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 1; i < n; i++) {
            int u = i;
            int v = parent[i];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        DFS(adj, 0, -1, s);
        return result;
    }
}

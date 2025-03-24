import java.util.*;

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] d : dislikes) {
            adj.get(d[0]).add(d[1]);
            adj.get(d[1]).add(d[0]);
        }

        // Step 2: Color array, -1 means uncolored
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);

        // Step 3: Try to color each component using BFS
        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) { // Unvisited node, start BFS
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i] = 0; // Start coloring with 0

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int neighbor : adj.get(node)) {
                        if (color[neighbor] == -1) { // Not colored yet
                            color[neighbor] = 1 - color[node]; // Assign opposite color
                            queue.add(neighbor);
                        } else if (color[neighbor] == color[node]) {
                            return false; // Conflict detected
                        }
                    }
                }
            }
        }
        return true; // Successfully colored without conflict
    }
}

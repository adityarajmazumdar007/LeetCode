import java.util.*;

class Solution {
    
    class Pair {
        int node, distance;
        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public int minScore(int n, int[][] roads) {
        List<List<Pair>> adjList = new ArrayList<>();

        // Corrected adjacency list initialization
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Build adjacency list
        for (int[] road : roads) {
            int u = road[0], v = road[1], distance = road[2];
            adjList.get(u).add(new Pair(v, distance));
            adjList.get(v).add(new Pair(u, distance));
        }

        Queue<Pair> bfs = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int minDistance = Integer.MAX_VALUE;

        bfs.offer(new Pair(1, 0)); // Start BFS from node 1
        visited[1] = true;

        while (!bfs.isEmpty()) {
            Pair parent = bfs.poll();
            int node = parent.node;

            for (Pair p : adjList.get(node)) {
                // Update minDistance correctly
                minDistance = Math.min(minDistance, p.distance);

                if (!visited[p.node]) {
                    bfs.offer(new Pair(p.node, p.distance));
                    visited[p.node] = true;
                }
            }
        }

        return minDistance;
    }
}

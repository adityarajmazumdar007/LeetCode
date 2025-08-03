import java.util.*;

public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Step 1: Build adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>())
                 .add(new int[]{edge[1], edge[2]});
        }

        // Step 2: Initialize distances to MAX
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Step 3: Min-heap for (currentTime, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, k});

        // Step 4: Standard Dijkstra
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], node = curr[1];
            if (!graph.containsKey(node)) continue; // No outgoing edges
            for (int[] neighbor : graph.get(node)) {
                int next = neighbor[0], weight = neighbor[1];
                if (time + weight < dist[next]) {
                    dist[next] = time + weight;
                    pq.offer(new int[]{dist[next], next});
                }
            }
        }

        // Step 5: Find max time among all nodes
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1; // Unreachable node
            res = Math.max(res, dist[i]);
        }
        return res;
    }
}

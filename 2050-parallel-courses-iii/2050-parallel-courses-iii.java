import java.util.*;

class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[n];

        // Build adjacency list and compute in-degree
        for (int[] relation : relations) {
            int u = relation[0] - 1;
            int v = relation[1] - 1;

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] maxTime = new int[n]; // maxTime[i] = max time needed to complete course i

        // Push all independent courses (in-degree 0) into queue
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                maxTime[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();

            if (!adj.containsKey(u)) continue;

            for (int v : adj.get(u)) {
                // Update the finishing time of course `v` based on its prerequisites
                maxTime[v] = Math.max(maxTime[v], maxTime[u] + time[v]);
                indegree[v]--;

                if (indegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        return Arrays.stream(maxTime).max().getAsInt();
    }
}

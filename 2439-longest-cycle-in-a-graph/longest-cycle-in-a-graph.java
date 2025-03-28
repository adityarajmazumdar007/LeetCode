import java.util.*;

class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        int maxLength = -1;  // Initialize maxLength to -1 (if no cycle exists)

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            Map<Integer, Integer> nodeDistance = new HashMap<>();
            int distance = 0;
            int current = i;

            while (current != -1 && !visited[current]) {
                visited[current] = true;
                nodeDistance.put(current, distance++);
                current = edges[current];

                if (current != -1 && nodeDistance.containsKey(current)) {
                    int cycleLength = distance - nodeDistance.get(current);
                    maxLength = Math.max(maxLength, cycleLength);
                    break;
                }
            }
        }
        return maxLength;
    }
}

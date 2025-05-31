import java.util.*;

class Solution {
    public void dfs(int node, int[] edges, int[] dist, int d) {
        while (node != -1 && dist[node] == -1) {
            dist[node] = d;
            node = edges[node]; // Move to the next node
            d++;
        }
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);

        // Run DFS from node1 and node2 to calculate distances
        dfs(node1, edges, dist1, 0);
        dfs(node2, edges, dist2, 0);

        // Find the node with minimum max distance
        int minDist = Integer.MAX_VALUE, result = -1;
        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) { // Node is reachable from both
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minDist) {
                    minDist = maxDist;
                    result = i;
                }
            }
        }
        return result;
    }
}

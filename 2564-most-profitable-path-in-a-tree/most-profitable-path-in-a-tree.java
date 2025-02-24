import java.util.*;

class Solution {
    List<List<Integer>> gr;
    int[] parent, depth;

    public void dfs(int node, int par, int d) {
        depth[node] = d;
        parent[node] = par;
        for (int neighbor : gr.get(node)) {
            if (neighbor != par) {
                dfs(neighbor, node, d + 1);
            }
        }
    }

    public int dfs2(int node, int par, int[] amount) {
        int total = amount[node], maxChildProfit = Integer.MIN_VALUE;
        for (int neighbor : gr.get(node)) {
            if (neighbor != par) {
                maxChildProfit = Math.max(maxChildProfit, dfs2(neighbor, node, amount));
            }
        }
        return maxChildProfit == Integer.MIN_VALUE ? total : total + maxChildProfit;
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        gr = new ArrayList<>();
        parent = new int[n];
        depth = new int[n];

        for (int i = 0; i < n; i++) {
            gr.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            gr.get(edge[0]).add(edge[1]);
            gr.get(edge[1]).add(edge[0]);
        }

        dfs(0, -1, 0);
        int current = bob, bobDepth = 0;

        while (current != -1) {
            if (depth[current] > bobDepth) {
                amount[current] = 0;
            } else if (depth[current] == bobDepth) {
                amount[current] /= 2;
            }
            current = parent[current];
            bobDepth++;
        }

        return dfs2(0, -1, amount);
    }
}

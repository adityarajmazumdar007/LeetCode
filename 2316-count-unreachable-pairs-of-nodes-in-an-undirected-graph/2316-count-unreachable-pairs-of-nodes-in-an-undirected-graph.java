import java.util.*;

class Solution {
    class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findUltimateParent(int node) {
            if (node == parent[node]) {
                return node;
            }
            // Path Compression
            return parent[node] = findUltimateParent(parent[node]);
        }

        public boolean unionBySize(int node1, int node2) {
            int ultimateParent1 = findUltimateParent(node1);
            int ultimateParent2 = findUltimateParent(node2);

            if (ultimateParent1 == ultimateParent2) return false;

            if (size[ultimateParent1] < size[ultimateParent2]) {
                parent[ultimateParent1] = ultimateParent2;
                size[ultimateParent2] += size[ultimateParent1];
            } else {
                parent[ultimateParent2] = ultimateParent1;
                size[ultimateParent1] += size[ultimateParent2];
            }

            return true;
        }
    }

    public long countPairs(int n, int[][] edges) {
        DSU disjointSet = new DSU(n);

        for (int[] edge : edges) {
            disjointSet.unionBySize(edge[0], edge[1]);
        }

        // Count size of each connected component
        HashMap<Integer, Integer> componentSize = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parent = disjointSet.findUltimateParent(i);
            componentSize.put(parent, componentSize.getOrDefault(parent, 0) + 1);
        }

        // Count unreachable pairs
        long totalPairs = (long) n * (n - 1) / 2;
        long reachablePairs = 0;

        for (int size : componentSize.values()) {
            reachablePairs += (long) size * (size - 1) / 2;
        }

        return totalPairs - reachablePairs;
    }
}

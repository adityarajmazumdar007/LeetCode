class Solution {
    static class DSU {
        int[] parent;
        int[] size;
        int components;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            components = n;
        }

        int find(int x) {
            // Path compression
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return false; // cycle
            // Union by size
            if (size[ra] < size[rb]) { int t = ra; ra = rb; rb = t; }
            parent[rb] = ra;
            size[ra] += size[rb];
            components--;
            return true;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        if (n <= 0) return false;               // (defensive) invalid n
        if (edges.length != n - 1) return false;

        DSU dsu = new DSU(n);
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (!dsu.union(u, v)) return false; // found a cycle
        }
        // If edges == n-1 and no cycles, it's automatically connected
        return dsu.components == 1;
    }
}
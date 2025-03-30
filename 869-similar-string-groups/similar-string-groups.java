import java.util.*;

class Solution {
    class DSU {
        private int[] parent, size;

        public DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                // Union by size: attach the smaller tree to the larger tree
                if (size[rootX] > size[rootY]) {
                    parent[rootY] = rootX;
                    size[rootX] += size[rootY];
                } else {
                    parent[rootX] = rootY;
                    size[rootY] += size[rootX];
                }
            }
        }
    }

    private boolean checkSimilar(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                if (count > 2) return false;
            }
        }
        return count == 2 || count == 0;
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        DSU dsu = new DSU(n);

        // Try to union similar strings
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (checkSimilar(strs[i], strs[j])) {
                    dsu.union(i, j);
                }
            }
        }

        // Count unique components
        Set<Integer> uniqueGroups = new HashSet<>();
        for (int i = 0; i < n; i++) {
            uniqueGroups.add(dsu.find(i));
        }
        return uniqueGroups.size();
    }
}

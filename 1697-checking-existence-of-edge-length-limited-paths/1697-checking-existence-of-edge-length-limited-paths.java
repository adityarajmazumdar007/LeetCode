import java.util.*;

class Solution {
    private int[] parent;
    private int[] rank;
    
    private int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    
    private void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);
        
        if (xParent == yParent) {
            return;
        }
        
        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }
    
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        parent = new int[n];
        rank = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int m = queries.length;
        int[][] indexedQueries = new int[m][4];
        for (int i = 0; i < m; i++) {
            indexedQueries[i][0] = queries[i][0];
            indexedQueries[i][1] = queries[i][1];
            indexedQueries[i][2] = queries[i][2];
            indexedQueries[i][3] = i;
        }
        
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));
        Arrays.sort(indexedQueries, Comparator.comparingInt(a -> a[2]));
        
        boolean[] result = new boolean[m];
        int j = 0;
        
        for (int[] query : indexedQueries) {
            int u = query[0], v = query[1], w = query[2], idx = query[3];
            
            while (j < edgeList.length && edgeList[j][2] < w) {
                union(edgeList[j][0], edgeList[j][1]);
                j++;
            }
            
            result[idx] = find(u) == find(v);
        }
        
        return result;
    }
}

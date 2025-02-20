import java.util.*;

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long adj[][] = new long[26][26];

        for (int i = 0; i < 26; i++) {
            Arrays.fill(adj[i], Long.MAX_VALUE);
            adj[i][i] = 0;
        }

        int n = original.length;
        for (int i = 0; i < n; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            long conversionCost = cost[i];
            adj[from][to] = Math.min(adj[from][to], conversionCost);
        }

        for (int k = 0; k < 26; k++) {  
            for (int i = 0; i < 26; i++) {  
                for (int j = 0; j < 26; j++) {  
                    if (adj[i][k] != Long.MAX_VALUE && adj[k][j] != Long.MAX_VALUE) {
                        adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                    }
                }
            }
        }

        int m = source.length();
        long minCost = 0;

        for (int i = 0; i < m; i++) {
            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';

            if (adj[from][to] == Long.MAX_VALUE) {
                return -1L;
            }

            minCost += adj[from][to];
        }

        return minCost;
    }
}

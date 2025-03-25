import java.util.*;

class Solution {
    int m, n;
    int[][][] dp;
    int[][] apples;
    final int MOD = 1_000_000_007;

    public int ways(String[] pizza, int k) {
        m = pizza.length;
        n = pizza[0].length();
        dp = new int[m][n][k + 1];
        apples = new int[m][n];

        // Fill the apples matrix using bottom-right to top-left approach
        computeApples(pizza);

        // Initialize DP array with -1
        for (int[][] layer : dp)
            for (int[] row : layer)
                Arrays.fill(row, -1);

        return solve(0, 0, k);
    }

    private int solve(int i, int j, int k) {
        if (apples[i][j] < k) return 0;
        if (k == 1) return apples[i][j] > 0 ? 1 : 0;
        if (dp[i][j][k] != -1) return dp[i][j][k];

        int res = 0;

        // Try horizontal cuts
        for (int h = i + 1; h < m; h++) {
            if (apples[i][j] - apples[h][j] > 0) {
                res = (res + solve(h, j, k - 1)) % MOD;
            }
        }

        // Try vertical cuts
        for (int v = j + 1; v < n; v++) {
            if (apples[i][j] - apples[i][v] > 0) {
                res = (res + solve(i, v, k - 1)) % MOD;
            }
        }

        return dp[i][j][k] = res;
    }

    private void computeApples(String[] pizza) {
        for (int j = n - 1; j >= 0; j--) {
            for (int i = m - 1; i >= 0; i--) {
                apples[i][j] = (pizza[i].charAt(j) == 'A' ? 1 : 0);
                if (i + 1 < m) apples[i][j] += apples[i + 1][j]; // Add apples from below
                if (j + 1 < n) apples[i][j] += apples[i][j + 1]; // Add apples from right
                if (i + 1 < m && j + 1 < n) apples[i][j] -= apples[i + 1][j + 1]; // Remove double-counted region
            }
        }
    }
}

import java.util.Arrays;
import java.util.List;

class Solution {
    private int[][] dp;
    private int n;

    private int solve(int i, List<List<Integer>> piles, int k) {
        if (i >= n) {
            return 0;
        }

        if (dp[i][k] != -1) {
            return dp[i][k];
        }

        int notTaken = solve(i + 1, piles, k);
        int taken = 0;
        int sum = 0;

        for (int j = 0; j < Math.min(piles.get(i).size(), k); j++) {
            sum += piles.get(i).get(j);

            if (k - (j + 1) >= 0) {
                taken = Math.max(taken, sum + solve(i + 1, piles, k - (j + 1)));
            }
        }

        return dp[i][k] = Math.max(taken, notTaken);
    }

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        n = piles.size();
        dp = new int[n + 1][k + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, piles, k);
    }
}

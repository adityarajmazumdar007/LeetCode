import java.util.*;

class Solution {
    private int[][] dp;

    private int solve(int[] cuts, int left, int right) {
        if (right - left == 1) {
            return 0;
        }

        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        int result = Integer.MAX_VALUE;

        for (int index = left + 1; index <= right - 1; index++) {
            int cost = solve(cuts, left, index) + solve(cuts, index, right) + (cuts[right] - cuts[left]);
            result = Math.min(result, cost);
        }

        return dp[left][right] = result;
    }

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);

        int[] newCuts = new int[cuts.length + 2];
        newCuts[0] = 0;
        newCuts[newCuts.length - 1] = n;

        System.arraycopy(cuts, 0, newCuts, 1, cuts.length);

        int m = newCuts.length;
        dp = new int[m][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(newCuts, 0, m - 1);
    }
}

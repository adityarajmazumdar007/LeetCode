import java.util.Arrays;

class Solution {
    private int n;
    private int[][] dp;

    private int solve(int[] satisfaction, int i, int time) {
        if (i == n) return 0;

        if (dp[i][time] != -1) return dp[i][time];

        int include = satisfaction[i] * time + solve(satisfaction, i + 1, time + 1);
        int exclude = solve(satisfaction, i + 1, time);

        return dp[i][time] = Math.max(include, exclude);
    }

    public int maxSatisfaction(int[] satisfaction) {
        n = satisfaction.length;
        
        Arrays.sort(satisfaction); // Sort to maximize the contribution of positive values
        
        dp = new int[n + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        
        return solve(satisfaction, 0, 1);
    }
}

import java.util.Arrays;

public class Solution {
    private int n;
    private int[][] dp;

    private int solve(int idx, int remaining, int[] cost, int[] time) {
        if (remaining <= 0) return 0; // If no walls are left, cost is 0

        if (idx == n) return (int) 1e9; // If we run out of painters, return large cost

        if (dp[idx][remaining] != -1) return dp[idx][remaining];

        // Option 1: Paint the wall at idx
        int paint = cost[idx] + solve(idx + 1, remaining - 1 - time[idx], cost, time);

        // Option 2: Skip the current wall
        int notPaint = solve(idx + 1, remaining, cost, time);

        return dp[idx][remaining] = Math.min(paint, notPaint);
    }

    public int paintWalls(int[] cost, int[] time) {
        n = cost.length;
        dp = new int[n + 1][n + 1]; // Create a DP table of size (n+1) x (n+1)
        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, n, cost, time);
    }
}

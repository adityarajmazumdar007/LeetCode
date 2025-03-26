class Solution {
    private int n;
    private int[] dp;

    private int solve(int[] stoneValue, int i) {
        if (i == n) return 0;

        if (dp[i] != Integer.MIN_VALUE) return dp[i];

        dp[i] = stoneValue[i] - solve(stoneValue, i + 1);

        if (i + 1 < n)
            dp[i] = Math.max(dp[i], stoneValue[i] + stoneValue[i + 1] - solve(stoneValue, i + 2));

        if (i + 2 < n)
            dp[i] = Math.max(dp[i], stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - solve(stoneValue, i + 3));

        return dp[i];
    }

    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;
        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);

        int diff = solve(stoneValue, 0);

        if (diff < 0)
            return "Bob";
        else if (diff > 0)
            return "Alice";
        return "Tie";
    }
}

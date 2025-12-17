class Solution {
    long recur(int prices[], int i, int b, int k, long dp[][][]) {
        if (i >= prices.length)
            return (b == 0) ? 0L : (long) -1e18;
        if (k <= 0)
            return (b == 0) ? 0L : (long) -1e18;

        if (dp[i][b][k] != Long.MIN_VALUE)
            return dp[i][b][k];

        long skip = recur(prices, i + 1, b, k, dp);
        long ans;

        if (b == 0) 
        {
            long openLong = recur(prices, i + 1, 2, k, dp) - prices[i];
            long openShort = recur(prices, i + 1, 1, k, dp) + prices[i];
            ans = Math.max(skip, Math.max(openLong, openShort));
        }
        else if (b == 1) 
        {
            ans = Math.max(skip, recur(prices, i + 1, 0, k - 1, dp) - prices[i]);
        } 
        else 
        {
            ans = Math.max(skip, recur(prices, i + 1, 0, k - 1, dp) + prices[i]);
        }

        return dp[i][b][k] = ans;
    }

    public long maximumProfit(int[] prices, int k) {  
        int n = prices.length;
        long[][][] dp = new long[n][3][k + 1];
        for (long[][] a : dp) {
            for (long[] b : a)
                Arrays.fill(b, Long.MIN_VALUE);
        }
        return recur(prices, 0, 0, k, dp); 
    }
}
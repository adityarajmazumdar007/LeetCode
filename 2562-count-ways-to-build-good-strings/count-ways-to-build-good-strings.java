class Solution {
    static final int MOD = 1_000_000_007;
    Integer[] dp;
    
    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new Integer[high + 1]; // Memoization table
        return countWays(0, low, high, zero, one);
    }
    
    private int countWays(int length, int low, int high, int zero, int one) {
        if (length > high) return 0;
        if (dp[length] != null) return dp[length];
        
        int count = (length >= low) ? 1 : 0;
        count = (count + countWays(length + zero, low, high, zero, one)) % MOD;
        count = (count + countWays(length + one, low, high, zero, one)) % MOD;
        
        return dp[length] = count;
    }
}

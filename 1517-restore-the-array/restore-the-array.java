class Solution {
    
    private int n;
    private final int MOD = 1_000_000_007;

    public int solve(int start, String s, int k, int[] dp) {
        
        if (start >= n)
            return 1;
        
        if (dp[start] != -1)
            return dp[start];
        
        if (s.charAt(start) == '0')
            return dp[start] = 0;
        
        long ans = 0;
        long num = 0;
        
        for (int end = start; end < n; end++) {
            num = (num * 10) + (s.charAt(end) - '0');
            
            if (num > k)
                break;
            
            ans = (ans + solve(end + 1, s, k, dp)) % MOD;
        }
        
        return dp[start] = (int) ans;
    }
    
    public int numberOfArrays(String s, int k) {
        n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return solve(0, s, k, dp);
    }
}

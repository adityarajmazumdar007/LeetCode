class Solution {

    private int m, k;
    private final int MOD = 1_000_000_007;
    private int[][] dp;

    public int solve(int i, int j, long[][] freq, String target) {
        if (i == m) 
            return 1;
        
        if (j == k) 
            return 0;
        
        if (dp[i][j] != -1) 
            return dp[i][j];

        // Case 1: Skip the current column (not taken)
        int notTaken = solve(i, j + 1, freq, target) % MOD;

        // Case 2: Take the current column (if possible)
        long taken = (freq[target.charAt(i) - 'a'][j] * (long) solve(i + 1, j + 1, freq, target)) % MOD;

        return dp[i][j] = (int) ((notTaken + taken) % MOD);
    }

    public int numWays(String[] words, String target) {
        k = words[0].length();
        m = target.length();
        
        // Frequency array for character counts at each position
        long[][] freq = new long[26][k];

        for (int col = 0; col < k; col++) {
            for (String word : words) {
                freq[word.charAt(col) - 'a'][col]++;
            }
        }

        dp = new int[m][k];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, freq, target);
    }
}

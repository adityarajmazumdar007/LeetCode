class Solution {

    private static final int MOD = 1_000_000_007;

    // dp[rowRemaining][previousPattern]
    private int[][] dp;

    // All valid color patterns for one row (3 columns)
    private final String[] patterns = {
        "RYG", "RGY", "RYR", "RGR",
        "YRG", "YGR", "YGY", "YRY",
        "GRY", "GYR", "GRG", "GYG"
    };

    private int countWays(int rowsLeft, int prevPatternIndex) {
        if (rowsLeft == 0) {
            return 1;
        }

        if (dp[rowsLeft][prevPatternIndex] != -1) {
            return dp[rowsLeft][prevPatternIndex];
        }

        int ways = 0;
        String prevPattern = patterns[prevPatternIndex];

        for (int curr = 0; curr < patterns.length; curr++) {
            if (curr == prevPatternIndex) continue;

            String currPattern = patterns[curr];
            boolean isValid = true;

            // Check column-wise color conflict
            for (int col = 0; col < 3; col++) {
                if (currPattern.charAt(col) == prevPattern.charAt(col)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                ways = (ways + countWays(rowsLeft - 1, curr)) % MOD;
            }
        }

        return dp[rowsLeft][prevPatternIndex] = ways;
    }

    public int numOfWays(int n) {
        dp = new int[n][patterns.length];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < patterns.length; j++) {
                dp[i][j] = -1;
            }
        }

        int totalWays = 0;

        // Pick each possible pattern as the first row
        for (int i = 0; i < patterns.length; i++) {
            totalWays = (totalWays + countWays(n - 1, i)) % MOD;
        }

        return totalWays;
    }
}

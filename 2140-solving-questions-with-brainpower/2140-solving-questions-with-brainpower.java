import java.util.*;

class Solution {
    public long helper(int[][] questions, int index, long[] dp) {
        if (index >= questions.length) return 0;
        if (dp[index] != -1) return dp[index];

        // Solve recursively with memoization
        long take = questions[index][0] + helper(questions, index + questions[index][1] + 1, dp);
        long skip = helper(questions, index + 1, dp);

        return dp[index] = Math.max(take, skip);
    }

    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        Arrays.fill(dp, -1);
        return helper(questions, 0, dp);
    }
}

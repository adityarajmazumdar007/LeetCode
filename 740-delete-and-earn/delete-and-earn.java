import java.util.*;

class Solution {
    public int deleteAndEarn(int[] nums) {
        // Edge case
        if (nums == null || nums.length == 0) return 0;

        // Step 1: Find max number for array size
        int max = 0;
        for (int num : nums) {
            if (num > max) max = num;
        }

        // Step 2: Build points array where points[i] is total points from i
        int[] points = new int[max + 1];
        for (int num : nums) {
            points[num] += num;
        }

        // Step 3: DP base cases
        int[] dp = new int[max + 1];
        dp[0] = 0;
        dp[1] = points[1];

        // Step 4: DP recurrence
        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + points[i]);
        }

        return dp[max];
    }
}

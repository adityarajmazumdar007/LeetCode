import java.util.Arrays;

class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        
        if (n <= 2) return n;
        
        int[][] dp = new int[n][1001]; 
        // dp[i][diff] = Max AP length till index i with common difference diff

        int result = 0;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j] + 500; // To handle negative differences
                
                dp[i][diff] = (dp[j][diff] > 0) ? dp[j][diff] + 1 : 2;
                
                result = Math.max(result, dp[i][diff]);
            }
        }
        
        return result;
    }
}

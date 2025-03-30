class Solution {
    public boolean validPartition(int[] nums) {
        return solve(nums, 0, new Boolean[nums.length]);
    }
    
    public boolean solve(int[] nums, int i, Boolean[] dp){
        if(i == nums.length)
            return true;
        
        if(dp[i] != null)
            return dp[i];

        boolean result = false;
        
        if((i + 1) < nums.length && (nums[i] == nums[i+1]))
            result |= solve(nums, i+2, dp);
        
        if((i + 2) < nums.length && nums[i] == nums[i+1] && nums[i+1] == nums[i+2])
            result |= solve(nums, i+3, dp);
        
        if((i + 2) < nums.length && ((nums[i] + 1) == nums[i+1]) && ((nums[i] + 2) == nums[i+2]))
            result |= solve(nums, i+3, dp);

        return dp[i] = result;
    }
}
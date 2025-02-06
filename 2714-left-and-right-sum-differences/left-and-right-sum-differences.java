class Solution {
    public int[] leftRightDifference(int[] nums) {
        int lSum = 0;
        int rSum = 0;
        int ans [] = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            rSum += nums[i];
        }
        for(int i = 0; i < nums.length; i++) {
            rSum -= nums[i];
            ans[i] = Math.abs(lSum - rSum);
            lSum +=nums[i];
        }
        return ans;
    }
}
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, smax = -99999;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            smax = Math.max(smax, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return smax;
    }
}


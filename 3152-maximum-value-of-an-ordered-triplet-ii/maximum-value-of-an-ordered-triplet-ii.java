class Solution {
    public long maximumTripletValue(int[] nums) {
        int maxE = nums[0];
        long maxV = 0;
        int maxD = 0;
        if(nums.length < 3) return 0;
        for (int j = 1; j < nums.length - 1; j++) {
            maxD = Math.max(maxD, maxE - nums[j]);
            maxE = Math.max(maxE, nums[j]);
            long currentV = (long)maxD * nums[j+1];
            maxV = Math.max(maxV, currentV); 
        }
        return maxV;
    }
 }
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxC = 0;
        int c = 0;
        for ( int i =0 ; i < nums.length; i++) {
            if(nums[i] == 1) {
                c++;
                maxC = Math.max(maxC, c);
            }
            else {
                c = 0;
            }
        }
        return maxC;
    }
}
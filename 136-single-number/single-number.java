class Solution {
    public int singleNumber(int[] nums) {
        int xorA = nums[0];
        for ( int i = 1; i < nums.length; i++) {
            xorA ^= nums[i];
        }
        return xorA;
    }
}
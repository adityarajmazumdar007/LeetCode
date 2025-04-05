class Solution {
    public int subsetXORSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        return calculateXorTotal(nums, 0 , 0);
    }

    private int calculateXorTotal(int[] nums, int index, int currentXor) {

        if(index == nums.length) return currentXor;

        int include = calculateXorTotal(nums, index + 1, currentXor ^ nums[index]);

        int exclude = calculateXorTotal(nums, index + 1, currentXor);

        return include + exclude;
    }
}
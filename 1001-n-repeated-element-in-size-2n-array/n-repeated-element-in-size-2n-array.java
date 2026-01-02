class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!used.add(nums[i])) {
                return nums[i];
            }
        }
        return 0;
    }
}
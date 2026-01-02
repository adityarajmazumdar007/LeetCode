class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!st.add(nums[i])) return nums[i];
        }
        return 0;
    }
}
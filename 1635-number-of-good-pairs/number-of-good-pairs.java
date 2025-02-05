class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap <Integer, Integer> mp = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++ ) {
            count +=mp.getOrDefault(nums[i], 0);
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) +1);
        }
        return count;
    }
}
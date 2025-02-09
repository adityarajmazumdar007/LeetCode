class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Long> mp = new HashMap<>();
        long n = (long)nums.length;
        long count = 0;
        for (int i = 0 ; i < nums.length; i++) {
            int diff = (nums[i] - i);
            count += mp.getOrDefault(diff, 0L);
            mp.put(diff, mp.getOrDefault(diff, 0L) +1L);
        }
        return n*(n-1)/2 - count;
    }
}
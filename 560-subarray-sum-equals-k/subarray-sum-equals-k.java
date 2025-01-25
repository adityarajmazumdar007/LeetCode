class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0,1);
        int result = 0;
        int prefixSum = 0;
        for( int i =0; i< nums.length; i++) {
            prefixSum += nums[i];
            result += mp.getOrDefault(prefixSum - k,0);
            mp.put(prefixSum, mp.getOrDefault(prefixSum,0) +1);
        }
        return result;
    }
}
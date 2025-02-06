class Solution {
    public int minSubArrayLen(int k, int[] nums) {
        int sz = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int n = nums.length;
        int sum = 0;
        
        while (j < n) {
            sum += nums[j];
            
            while (sum >= k) {
                sz = Math.min(sz, j - i + 1);
                sum -= nums[i];
                i++;
            }
            
            j++;
        }
        
        if (sz == Integer.MAX_VALUE) return 0;
        return sz;
    }
}
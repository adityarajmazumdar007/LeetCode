class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int res = Integer.MIN_VALUE;
        while (j < nums.length) {
            sum += nums[j];
            if ( j - i +1 > k) {
                sum -= nums[i++];
            }
            if ( j- i +1 == k) {
                res = Math.max(sum, res);
            }
            j++; 
        }
        return (double)res/(double)k;
    }
}
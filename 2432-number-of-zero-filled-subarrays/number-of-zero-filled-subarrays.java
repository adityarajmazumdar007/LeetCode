class Solution {
    public long zeroFilledSubarray(int[] nums) {
          long ans = 0L;     // total number of zero-filled subarrays
        long run = 0L;     // length of the current consecutive zero run

        for (int x : nums) {
            if (x == 0) {
                run++;         // extend the zero run
                ans += run;    // add all new subarrays ending here
            } else {
                run = 0;       // break the run
            }
        }
        return ans;
    }
}
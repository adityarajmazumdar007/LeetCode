class Solution {
    public int maxAdjacentDistance(int[] nums) {
         if (nums == null || nums.length <= 1) return 0;

        int n = nums.length;
        int maxDiff = 0;

        // Scan each element and its next neighbor (wrap via modulo)
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;                  // neighbor index (wrap-around)
            int diff = Math.abs(nums[i] - nums[j]); // absolute difference for this pair
            if (diff > maxDiff) maxDiff = diff;     // keep the best
        }

        return maxDiff;
    }
}
import java.util.Arrays;

public class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);  // Sort nums for easier difference checks

        int left = 0;
        int right = nums[nums.length - 1] - nums[0];  // Max possible difference

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canFormPairs(nums, p, mid)) {
                // If possible to form p pairs with max diff <= mid, try smaller diff
                right = mid;
            } else {
                // Otherwise, increase diff
                left = mid + 1;
            }
        }

        return left;  // The minimized maximum difference
    }

    // Helper to check if p pairs can be formed with max difference <= diff
    private boolean canFormPairs(int[] nums, int p, int diff) {
        int count = 0;
        int i = 0;

        while (i < nums.length - 1) {
            if (nums[i + 1] - nums[i] <= diff) {
                count++;  // Form a pair
                i += 2;   // Skip both elements
            } else {
                i++;      // Try next element
            }
            if (count >= p) return true;  // Early stop if p pairs formed
        }

        return false;
    }
}

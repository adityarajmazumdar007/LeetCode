public class Solution {
    public int longestSubarray(int[] nums) {
        // Edge case: empty array
        if (nums == null || nums.length == 0) return 0;

        // Step 1: Find the maximum number in the array
        int maxNum = nums[0];
        for (int num : nums) {
            if (num > maxNum) {
                maxNum = num;
            }
        }

        // Step 2: Scan to find longest contiguous segment of maxNum
        int currentLength = 0; // Current length of segment
        int maxLength = 0;     // Result: max segment length found

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == maxNum) {
                currentLength++;         // valid segment continues
                maxLength = Math.max(maxLength, currentLength); // update max
            } else {
                currentLength = 0;       // reset segment
            }
        }

        return maxLength;
    }
}

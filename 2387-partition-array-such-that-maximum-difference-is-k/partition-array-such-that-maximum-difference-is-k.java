import java.util.Arrays;

public class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);  // Sort to get increasing order

        int count = 1;      // At least one subsequence needed
        int start = nums[0]; // Start of current subsequence

        for (int i = 1; i < nums.length; i++) {
            // Check if current number breaks the max-min ≤ k condition
            if (nums[i] - start > k) {
                count++;      // Need a new subsequence
                start = nums[i]; // Reset start for new subsequence
            }
        }

        return count;  // Minimum subsequences required
    }
}

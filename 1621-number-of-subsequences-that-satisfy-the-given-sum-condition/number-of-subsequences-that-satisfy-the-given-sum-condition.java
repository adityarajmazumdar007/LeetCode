import java.util.Arrays;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);  // Sort for two-pointer approach
        int n = nums.length;

        // Precompute powers of 2 mod MOD
        int[] pow2 = new int[n + 1];
        pow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        int left = 0, right = n - 1;
        int result = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                // All subsequences between left and right starting with nums[left] are valid
                result = (result + pow2[right - left]) % MOD;
                left++;
            } else {
                // Reduce max to try to satisfy condition
                right--;
            }
        }

        return result;
    }
}

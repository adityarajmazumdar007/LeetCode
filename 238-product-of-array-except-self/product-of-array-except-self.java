public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        // Edge case: if array length is 0 or 1, just return nums (or empty)
        if (n == 0) return new int[0];
        if (n == 1) return new int[] {1};

        // Initialize prefix and suffix product arrays
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] output = new int[n];

        // prefix[i] stores product of all elements before index i
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // suffix[i] stores product of all elements after index i
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        // Calculate output by multiplying prefix and suffix products
        for (int i = 0; i < n; i++) {
            output[i] = prefix[i] * suffix[i];
        }

        return output;
    }
}

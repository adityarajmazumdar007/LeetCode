class Solution {
    public int maxProduct(int[] nums) {
        // Edge case: if the input array is empty, return 0 (though constraints say n >= 1)
        if (nums == null || nums.length == 0) return 0;

        // Initialize maxProduct, currMax, currMin to the first element
        int maxProduct = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        // Iterate through the rest of the array
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // Save current currMax and currMin before updating
            int prevMax = currMax;
            int prevMin = currMin;

            // Calculate new currMax and currMin at this index
            // If num is negative, multiplying prevMin (which may be a large negative) could make a large positive
            currMax = Math.max(num, Math.max(prevMax * num, prevMin * num));
            currMin = Math.min(num, Math.min(prevMax * num, prevMin * num));

            // Update maxProduct if current currMax is greater
            maxProduct = Math.max(maxProduct, currMax);
        }

        // Return the largest product found
        return maxProduct;
    }
}

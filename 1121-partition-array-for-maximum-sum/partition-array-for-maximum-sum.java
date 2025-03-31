class Solution {
    public int helper(int arr[], int index, int k, int[] dp) {
        if (index >= arr.length) return 0; // Base case
        if (dp[index] != -1) return dp[index]; // Return if already computed

        int maxValue = -1;
        int result = 0;

        for (int currentIdx = index; currentIdx < Math.min(index + k, arr.length); currentIdx++) {
            maxValue = Math.max(maxValue, arr[currentIdx]);
            int partitionSize = currentIdx - index + 1;
            result = Math.max(result, (maxValue * partitionSize) + helper(arr, currentIdx + 1, k, dp));
        }

        return dp[index] = result; // Store result
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return helper(arr, 0, k, dp);
    }
}

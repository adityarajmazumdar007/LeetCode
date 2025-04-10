class Solution {
    int dp[][];
    public int helper (int []nums1, int []nums2, int index_1, int index_2) {
        if (index_1 >= nums1.length || index_2 >= nums2.length) {
            return 0;
        }
        if (dp[index_1][index_2] != -1) return dp[index_1][index_2];

        if (nums1[index_1] == nums2[index_2]) {
            return dp[index_1][index_2] = 1 + helper(nums1, nums2, index_1+1, index_2 + 1);
        }

        return dp[index_1][index_2] = Math.max(0 + helper( nums1, nums2, index_1+1, index_2), helper(nums1, nums2, index_1, index_2 + 1));
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int index_1 = 0;
        int index_2 = 0;
        dp = new int[nums1.length][nums2.length];
        for( int arr[] : dp) {
            Arrays.fill(arr, -1);
        }
        return helper(nums1, nums2, index_1, index_2);
    }
}
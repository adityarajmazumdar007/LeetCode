import java.util.Arrays;

public class Solution {
    private int m, n;
    private Integer[][] dp;

    public int maxDotProduct(int[] nums1, int[] nums2) {
        m = nums1.length;
        n = nums2.length;
        dp = new Integer[m][n];

        return solve(nums1, nums2, 0, 0);
    }

    private int solve(int[] nums1, int[] nums2, int i, int j) {
        if (i == m || j == n) return Integer.MIN_VALUE; // Prevents incorrect sum

        if (dp[i][j] != null) return dp[i][j];

        int val = nums1[i] * nums2[j];

        int takeBoth = solve(nums1, nums2, i + 1, j + 1);
        if (takeBoth != Integer.MIN_VALUE) takeBoth += val;

        int skipI = solve(nums1, nums2, i + 1, j);
        int skipJ = solve(nums1, nums2, i, j + 1);

        // Best option: max of taking (i, j), skipping i, skipping j, or taking just `val` alone
        return dp[i][j] = Math.max(val, Math.max(takeBoth, Math.max(skipI, skipJ)));
    }
}

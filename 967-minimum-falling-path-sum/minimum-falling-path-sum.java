class Solution {
    public int solve(int row, int col, int[][] matrix, int[][] dp) {
        int n = matrix.length;
        if (row < 0 || col < 0 || row >= n || col >= n) return Integer.MAX_VALUE;
        if (row == 0) return matrix[0][col];
        if (dp[row][col] != (int)1e9) return dp[row][col];
        int leftUp = solve(row - 1, col - 1, matrix, dp);
        int up = solve(row - 1, col, matrix, dp);
        int rightUp = solve(row - 1, col + 1, matrix, dp);

        dp[row][col] = matrix[row][col] + Math.min(leftUp, Math.min(up, rightUp));
        return dp[row][col];
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int minSum = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, (int)1e9);
        }

        for (int i = 0; i < n; i++) {
            minSum = Math.min(minSum, solve(n - 1, i, matrix, dp));
        }
        return minSum;
    }
}

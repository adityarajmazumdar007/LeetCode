class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;

        int[][] t = new int[n][n];
        for (int[] row : t) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for (int col = 0; col < n; col++) {
            t[n - 1][col] = grid[n - 1][col];
        }

        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < n; col++) {
                int ans = Integer.MAX_VALUE;
                for (int nextCol = 0; nextCol < n; nextCol++) {
                    if (nextCol != col) {
                        ans = Math.min(ans, t[row + 1][nextCol]);
                    }
                }
                t[row][col] = grid[row][col] + ans;
            }
        }

        int result = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            result = Math.min(result, t[0][col]);
        }

        return result;
    }
}
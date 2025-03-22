import java.util.Arrays;

class Solution {
    private static final int MOD = 1_000_000_007; 
    private int[][][] memo; 

    public int numberOfPaths(int[][] grid, int k) {
        int rows = grid.length, cols = grid[0].length;
        memo = new int[rows][cols][k]; // DP table: (row, col, sum % k)

        for (int[][] row : memo) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }

        return findPaths(grid, 0, 0, 0, k);
    }

    private int findPaths(int[][] grid, int row, int col, int sum, int k) {
        int rows = grid.length, cols = grid[0].length;

        int newSumMod = (sum + grid[row][col]) % k;

        if (row == rows - 1 && col == cols - 1) {
            return (newSumMod == 0) ? 1 : 0;
        }

        if (memo[row][col][newSumMod] != -1) {
            return memo[row][col][newSumMod];
        }

        // Move Right or Down
        int rightPaths = (col + 1 < cols) ? findPaths(grid, row, col + 1, newSumMod, k) : 0;
        int downPaths = (row + 1 < rows) ? findPaths(grid, row + 1, col, newSumMod, k) : 0;

        // Store and return total paths (modulo to prevent overflow)
        return memo[row][col][newSumMod] = (rightPaths + downPaths) % MOD;
    }
}

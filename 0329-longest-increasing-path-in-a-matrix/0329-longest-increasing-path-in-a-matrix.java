import java.util.Arrays;

class Solution {
    private int m, n;
    private final int[][] directions = {
            {-1, 0}, {0, -1}, {0, 1}, {1, 0}
    };

    private int[][] memo;

    private boolean isSafe(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (memo[i][j] != -1) return memo[i][j];

        int maxLength = 1; // Minimum path length is 1 (just the cell itself)

        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];

            if (isSafe(newRow, newCol) && grid[newRow][newCol] > grid[i][j]) {
                maxLength = Math.max(maxLength, 1 + dfs(grid, newRow, newCol));
            }
        }

        return memo[i][j] = maxLength;
    }

    public int longestIncreasingPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int maxPath = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxPath = Math.max(maxPath, dfs(grid, i, j));
            }
        }

        return maxPath;
    }
}

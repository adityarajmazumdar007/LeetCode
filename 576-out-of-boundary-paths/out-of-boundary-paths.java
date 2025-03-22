import java.util.Arrays;

class Solution {
    private static final int MODULO = 1_000_000_007;
    private int[][][] memo; // Memoization table
    
    public int findPaths(int rows, int cols, int maxMoves, int startRow, int startCol) {
        // Initialize memoization table with -1 (indicating uncomputed values)
        memo = new int[rows][cols][maxMoves + 1];
        for (int[][] row : memo) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        
        return countWays(rows, cols, maxMoves, startRow, startCol);
    }
    
    private int countWays(int rows, int cols, int remainingMoves, int row, int col) {
        // \U0001f6a8 Base Case 1: If the ball moves out of bounds, it's a valid path.
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return 1;
        }

        // \U0001f6a8 Base Case 2: If no moves left and still inside, no valid path.
        if (remainingMoves == 0) {
            return 0;
        }

        // If already computed, return the cached result.
        if (memo[row][col][remainingMoves] != -1) {
            return memo[row][col][remainingMoves];
        }

        // \U0001f3af Recursively compute the number of ways by moving in four directions.
        long paths = 0;
        paths += countWays(rows, cols, remainingMoves - 1, row - 1, col); // Move Up
        paths += countWays(rows, cols, remainingMoves - 1, row + 1, col); // Move Down
        paths += countWays(rows, cols, remainingMoves - 1, row, col - 1); // Move Left
        paths += countWays(rows, cols, remainingMoves - 1, row, col + 1); // Move Right

        // Store the result in the memo table and take modulo.
        return memo[row][col][remainingMoves] = (int) (paths % MODULO);
    }
}

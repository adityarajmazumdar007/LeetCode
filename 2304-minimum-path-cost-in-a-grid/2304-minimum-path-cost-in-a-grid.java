class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int rows = grid.length, cols = grid[0].length;
        Integer[][] memo = new Integer[rows][cols]; // Memoization table

        int minTotalCost = Integer.MAX_VALUE;
        for (int startCol = 0; startCol < cols; startCol++) {
            minTotalCost = Math.min(minTotalCost, findMinCost(0, startCol, grid, moveCost, memo));
        }
        return minTotalCost;
    }

    private int findMinCost(int row, int col, int[][] grid, int[][] moveCost, Integer[][] memo) {
        int rows = grid.length, cols = grid[0].length;

        // Base Case: If we reach the last row, return the cell value
        if (row == rows - 1) return grid[row][col];

        // Return cached result if already computed
        if (memo[row][col] != null) return memo[row][col];

        int currentCellValue = grid[row][col];
        int minPathCost = Integer.MAX_VALUE;

        // Try moving to every column in the next row
        for (int nextCol = 0; nextCol < cols; nextCol++) {
            int transitionCost = moveCost[currentCellValue][nextCol];
            int totalCost = grid[row][col] + transitionCost + findMinCost(row + 1, nextCol, grid, moveCost, memo);
            minPathCost = Math.min(minPathCost, totalCost);
        }

        // Store the computed result in memoization table
        return memo[row][col] = minPathCost;
    }
}

class Solution {
    int[][] fruits;
    int rows;
    int cols;

    int[][] directions1  = new int[][] {{1, -1}, {1, 0}, {1, 1}};
    int[][] directions2 = new int[][] {{-1, 1}, {0, 1}, {1, 1}};

    public int maxCollectedFruits(int[][] fruits) {
        this.fruits = fruits;

        rows = fruits.length;
        cols = fruits[0].length;

        int fruitsCollected = 0;

        for (int row = 0; row < rows; row++) {
            fruitsCollected += fruits[row][row]; // rows == cols
            fruits[row][row] = 0;
        }

        Integer[][] dp1 = new Integer[rows][cols];
        Integer[][] dp2 = new Integer[rows][cols];

        return fruitsCollected + helper(0, rows - 1, directions1, dp1, 0) + helper(rows - 1, 0, directions2, dp2, 0);
    }


    int helper(int curRow, int curCol, int[][] directions, Integer[][] dp, int moves) {
        if (curRow < 0 || curCol < 0 || curRow >= rows || curCol >= cols || moves >= rows) return Integer.MIN_VALUE;

        if (moves == rows - 1) {
            if (curRow == rows - 1 && curCol == cols - 1) return 0;
            return Integer.MIN_VALUE;
        }

        if (dp[curRow][curCol] != null) return dp[curRow][curCol];

        int maxFruits = Integer.MIN_VALUE;

        for (int[] direction: directions) {
            int nextRow = curRow + direction[0];
            int nextCol = curCol + direction[1];

            maxFruits = Math.max(maxFruits, fruits[curRow][curCol] + helper(nextRow, nextCol, directions, dp, 1 + moves));
        }

        return dp[curRow][curCol] = maxFruits;
    }
}
class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int startRow = startPos[0], startCol = startPos[1];
        int homeRow = homePos[0], homeCol = homePos[1];
        int totalCost = 0;

        // Move in the row direction (downward or upward)
        if (startRow < homeRow) {  // Moving downward
            for (int r = startRow + 1; r <= homeRow; r++) {
                totalCost += rowCosts[r];  // Add the cost for each row we move to
            }
        } else {  // Moving upward
            for (int r = startRow - 1; r >= homeRow; r--) {
                totalCost += rowCosts[r];  // Add the cost for each row we move to
            }
        }

        // Move in the column direction (rightward or leftward)
        if (startCol < homeCol) {  // Moving right
            for (int c = startCol + 1; c <= homeCol; c++) {
                totalCost += colCosts[c];  // Add the cost for each column we move to
            }
        } else {  // Moving left
            for (int c = startCol - 1; c >= homeCol; c--) {
                totalCost += colCosts[c];  // Add the cost for each column we move to
            }
        }

        return totalCost;  // Return the minimum cost to reach home
    }
}

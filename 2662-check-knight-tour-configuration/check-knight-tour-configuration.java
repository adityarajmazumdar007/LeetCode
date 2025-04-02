class Solution {
    public boolean checkValidGrid(int[][] grid) {
        
        int n = grid.length;

        if (grid[0][0] != 0) {
            return false;
        }

        int positions[][] = new int[n*n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                int value = grid[i][j];
                
                if (value < 0 || value > n*n) {
                    return false;
                }

                positions[value][0] = i;
                positions[value][1] = j;

            }
        }

        for (int i = 0; i < n*n - 1; i++) {

            int rowDifference = Math.abs(positions[i+1][0] - positions[i][0]);
            int colDifference = Math.abs(positions[i+1][1] - positions[i][1]);

            if (!((rowDifference == 1 && colDifference == 2) || (rowDifference == 2 && colDifference == 1))) {
                return false;
            }


        }
        return true;
    }
}
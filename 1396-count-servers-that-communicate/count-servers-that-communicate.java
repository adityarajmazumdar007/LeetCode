class Solution {
    public int countServers(int[][] grid) {
        int row [] = new int[grid[0].length];
        int col [] = new int[grid.length];
        for ( int i =0; i < grid.length; i++) {
            for( int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    col[i]++;
                    row[j]++;
                }
            }
        }
        int count = 0;
        for ( int i =0; i < grid.length; i++) {
            for( int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    if(col[i] > 1 || row[j] > 1) {
                        count++;
                    }
            }
            }
        }
        return count;
    }
}
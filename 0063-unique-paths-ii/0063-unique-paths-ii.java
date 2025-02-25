class Solution {
    public int helper ( int row, int col, int dp [][], int[][] obstacleGrid ) {
        if ( (row >= 0 && col >= 0 && obstacleGrid[row][col] == 1 ) ||
        (row < 0 || col <0 ) ) {
            return 0;
        }
        if(row==0 && col ==0 ) {
            return 1;
        }
        if(dp[row][col] != -1 ) {
            return dp[row][col];
        }
        int top = helper(row-1, col, dp, obstacleGrid );
        int left = helper(row, col-1, dp, obstacleGrid );
        return dp[row][col] = top + left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp [][] = new int[m][n];
        for ( int i =0; i < m; i++ ) {
            Arrays.fill ( dp[i], -1) ;
        }
        return helper( m-1, n-1, dp, obstacleGrid);
    }
}
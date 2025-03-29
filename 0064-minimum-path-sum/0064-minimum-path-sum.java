// class Solution {
//     public int minPathSum(int[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;
//         int dp [][] = new int[n][m];
//         dp[0][0] = grid[0][0];
//         for(int i = 1 ; i < n; i++) {
//             dp[i][0] = dp[i-1][0] + grid[i][0];
//         }

//         for(int j = 1 ; j < m; j++) {
//             dp[0][j] = dp[0][j-1] + grid[0][j];
//         }
        
//         for(int i = 1; i < n; i++) {
//             for(int j = 1; j < m; j++) {
//                 dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
//             }
//         }
//         return dp[n-1][m-1];
//     }
// }


class Solution {
    private static int solve(int row, int coloumn,int[][] grid,int storageSystem [][]){
        if(row==0 && coloumn==0)return grid[0][0] ;
        if(row< 0 || coloumn<0)return (int) Math.pow(10, 9);
        if(storageSystem[row][coloumn]!=-1)return storageSystem[row][coloumn];
        int leftward= grid[row][coloumn]+ solve(row,coloumn-1,grid,storageSystem);
        int upward = grid[row][coloumn]+ solve(row-1,coloumn,grid,storageSystem);
        storageSystem[row][coloumn]=Math.min(leftward,upward);
        return storageSystem[row][coloumn];
        
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int storageSystem [][] = new int[m][n];
        for (int i = 0; i < m; i++) {
        Arrays.fill(storageSystem[i], -1);
        }
        return solve(m-1,n-1,grid,storageSystem);
    }
}

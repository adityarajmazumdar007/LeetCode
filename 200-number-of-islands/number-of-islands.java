class Solution {
    public void dfs(int sr, int sc,
                    int delRow [], int delCol [],
                    int vis [][],
                    char [][] grid) {
        vis[sr][sc] = 1;
        int n = grid.length;
        int m = grid[0].length;
        for ( int i =0; i< 4; i++) {
            int nRow = sr + delRow[i];
            int nCol = sc+ delCol[i];
            if( nRow >=0 && nRow < n &&
              nCol >=0 && nCol < m &&
              grid[nRow][nCol] == '1' && vis[nRow][nCol] == 0) {
                dfs(nRow, nCol, delRow, delCol, vis, grid);
            }
        }
        return;
    }
    public int numIslands(char[][] grid) {
        int countOfIslands = 0;
        int vis [][] = new int [grid.length][grid[0].length];
        int delRow [] = {0, 1, 0, -1};
        int delCol [] = {1, 0, -1, 0};
        for ( int i = 0; i < grid.length; i++ ) {
            for ( int j = 0; j < grid[0].length; j++){
                if ( grid[i][j] == '1' 
                   && vis[i][j] == 0) {
                    countOfIslands++;
                    dfs( i, j, delRow, delCol, 
                       vis, grid);
                }
            }
        }
        return countOfIslands;
    }
}
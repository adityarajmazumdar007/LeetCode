class Solution {
     public void dfs ( int row, int col, int[][] board,
                     int vis [][],
                     int delRow[],
                     int delCol[]) {
        vis[row][col] = 1;
        int n = board.length;
        int m = board[0].length;
        for ( int i =0 ; i < 4; i++ ) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if ( nRow >= 0 && nRow < n &&
                 nCol >= 0 && nCol < m &&
                 vis[nRow][nCol] == 0 &&
                 board[nRow][nCol] == 1) {
                dfs ( nRow, nCol, board,
                      vis, delRow,
                      delCol);
            }
        }
    }
    public int numEnclaves(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int vis[][] = new int[n][m];
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};
        for ( int j = 0 ; j < m; j++) {
            if(board[0][j] == 1 && vis [0][j] == 0) {
                dfs ( 0, j, board, vis, delRow, delCol);
            }
            if(board[n-1][j] == 1 && vis [n-1][j] == 0) {
                dfs ( n-1, j, board, vis, delRow, delCol);
            }
        }
        for ( int i = 0 ; i <  n; i++) {
            if(board[i][0] == 1 && vis [i][0] == 0) {
                dfs ( i, 0, board, vis, delRow, delCol);
            }
            if(board[i][m-1] == 1 && vis [i][m-1] == 0) {
                dfs ( i, m-1, board, vis, delRow, delCol);
            }
        }
        int lands = 0;
        for ( int i = 0; i < n ; i++) {
            for ( int j = 0; j < m; j++) {
                if ( board [i][j] == 1 && vis [i][j] == 0) {
                    lands++;
                }
            }
        }
        return lands;
    }
}
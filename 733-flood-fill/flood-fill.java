class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    // public void floodFillDfs(int sr, int sc, int ans[][], int image[][],
    //                          int delRow[], int delCol[],
    //                          int initialColor,
    //                          int newColor) {
    //     int n = image.length;
    //     int m = image[0].length;
    //     ans[sr][sc] = newColor;
    //     for (int i = 0; i < 4; i++) {
    //         int nRow = sr + delRow[i];
    //         int nCol = sc + delCol[i];
    //         if( nRow >= 0 && nRow <n &&
    //           nCol >= 0 && nCol < m
    //           && image[nRow][nCol] == initialColor
    //           && ans[nRow][nCol] != newColor){
    //             floodFillDfs(nRow, nCol, ans, image,
    //                         delRow, delCol, 
    //                         initialColor, newColor);
    //         }
    //     }
    // }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int initialColor = image[sr][sc];
        int ans [][] = image;
        int delRow [] = {0, 1, 0, -1};
        int delCol [] = {1, 0, -1, 0};
        Queue <Pair> q = new LinkedList<>();
        q.offer(new Pair(sr, sc));
        int n = image.length;
        int m = image[0].length;
        ans[sr][sc] = newColor;
        while(q.size() != 0) {
            Pair p = q.poll();
            int currRow = p.row;
            int currCol = p.col;
            for (int i = 0; i < 4; i++) {
                int nRow = currRow + delRow[i];
                int nCol = currCol + delCol[i];
                if( nRow >= 0 && nRow <n &&
                nCol >= 0 && nCol < m
                && image[nRow][nCol] == initialColor
                && ans[nRow][nCol] != newColor){
                    ans[nRow][nCol] = newColor;
                    q.offer(new Pair(nRow, nCol));
            }
        }

        }
        // floodFillDfs(sr, sc, ans, image,
        //              delRow, delCol,
        //              initialColor,
        //              newColor);
        return ans;
    }
}
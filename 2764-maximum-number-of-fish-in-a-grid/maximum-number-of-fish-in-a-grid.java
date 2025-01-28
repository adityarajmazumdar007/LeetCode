class Solution {
    public int dfs(int sr, int sc, int[] delRow, int[] delCol, int[][] vis, int[][] grid) {
        vis[sr][sc] = 1; 
        int n = grid.length;
        int m = grid[0].length;
        int fishCount = grid[sr][sc]; 

        for (int i = 0; i < 4; i++) {
            int nRow = sr + delRow[i];
            int nCol = sc + delCol[i];
            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] != 0 && vis[nRow][nCol] == 0) {
                fishCount += dfs(nRow, nCol, delRow, delCol, vis, grid); 
            }
        }
        return fishCount;
    }

    public int findMaxFish(int[][] grid) {
        int maxFish = 0;
        int vis[][] = new int[grid.length][grid[0].length]; 
        int delRow[] = {0, 1, 0, -1};
        int delCol[] = {1, 0, -1, 0}; 

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0 && vis[i][j] == 0) {
                    maxFish = Math.max(maxFish, dfs(i, j, delRow, delCol, vis, grid));
                }
            }
        }
        return maxFish;
    }
}

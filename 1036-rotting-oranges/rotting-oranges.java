class Solution {
    class Pair {
        int row;
        int col;
        int time;

        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int countFresh = 0;
        int dRow[] = { 0, 1, 0, -1 };
        int dCol[] = { 1, 0, -1, 0 };
        int dis[][] = new int[n][m];
        int vis[][] = new int[n][m];
        Queue<Pair> bfsQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    bfsQueue.offer(new Pair(i, j, 0));
                    vis[i][j] = 1;
                }
                if (grid[i][j] == 1)
                    countFresh++;
            }
        }
        int maxTime = 0;
        int countMarked = 0;
        while (bfsQueue.size() != 0) {
            Pair top = bfsQueue.poll();
            int r = top.row;
            int c = top.col;
            int d = top.time;
            maxTime = Math.max(maxTime, d);
            for (int i = 0; i < 4; i++) {
                int nRow = r + dRow[i];
                int nCol = c + dCol[i];
                if (nRow >= 0 && nRow < n &&
                        nCol >= 0 && nCol < m && grid[nRow][nCol] == 1
                        && vis[nRow][nCol] == 0) {
                    bfsQueue.offer(new Pair(nRow, nCol, d + 1));
                    vis[nRow][nCol] = 1;
                    countMarked++;
                }
            }
        }
        if (countFresh != countMarked) {
            return -1;
            }
        return maxTime;
    }
}
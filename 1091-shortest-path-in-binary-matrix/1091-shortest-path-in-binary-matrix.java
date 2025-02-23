class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1)
            return -1;
        Queue<int[]> q = new LinkedList<>();

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 1;
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for (int i = 0; i < 8; i++) {
                int newR = r + dr[i];
                int newC = c + dc[i];
                if (newR >= 0 && newR < n && newC >= 0 && newC < m && grid[newR][newC] == 0 && dist[newR][newC] > dist[r][c] + 1) {
                    dist[newR][newC] = dist[r][c] + 1;
                    q.offer(new int[]{newR, newC});
                }
            }
        }
        if (dist[n - 1][m - 1] == Integer.MAX_VALUE)
            return -1; 
        return dist[n - 1][m - 1];
    }
}
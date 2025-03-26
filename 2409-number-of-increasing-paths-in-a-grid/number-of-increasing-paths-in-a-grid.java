import java.util.Arrays;

class Solution {
    private int m, n;
    private final int[][] directions = {
            {-1, 0}, {0, -1}, {0, 1}, {1, 0}
    };
    
    private final long MOD = (long) 1e9 + 7;
    private int[][] memo;
    
    private boolean isSafe(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
    
    private int dfs(int[][] grid, int i, int j) {
        if (memo[i][j] != -1) return memo[i][j];
        
        int answer = 1;
        
        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            
            if (isSafe(newRow, newCol) && grid[newRow][newCol] < grid[i][j]) {
                answer = (int) ((answer + dfs(grid, newRow, newCol)) % MOD);
            }
        }
        
        return memo[i][j] = answer;
    }
    
    public int countPaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        int result = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = (int) ((result + dfs(grid, i, j)) % MOD);
            }
        }
        
        return result;
    }
}

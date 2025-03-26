import java.util.*;

class Solution {
    private Map<String, Double> memo = new HashMap<>();
    private int[][] directions = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

    private double helper(int N, int K, int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= N) 
            return 0; 
        
        if (K == 0)
            return 1;  // One possibility over, return now
        
        String key = K + "_" + row + "_" + col;
        
        if (memo.containsKey(key)) 
            return memo.get(key);
        
        double ans = 0;
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            ans += helper(N, K - 1, newRow, newCol);
        }
        
        double result = ans / 8.0;
        memo.put(key, result);
        return result;
    }

    public double knightProbability(int n, int k, int row, int column) {
        return helper(n, k, row, column);
    }
}

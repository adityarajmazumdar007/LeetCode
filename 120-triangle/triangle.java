class Solution {
    private static int solve(int row, int column, List<List<Integer>> triangle, int dp[][]) {
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(column);
        }
        if (dp[row][column] != -1) {
            return dp[row][column];
        }
        int downward = triangle.get(row).get(column) + solve(row + 1, column, triangle, dp);
        int diagonal = solve(row + 1, column + 1, triangle, dp) + triangle.get(row).get(column);
        return dp[row][column] = Math.min(downward, diagonal);
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for (int arr[] : dp) {
            Arrays.fill(arr, -1);
        }
        return solve(0, 0, triangle, dp);
    }
}
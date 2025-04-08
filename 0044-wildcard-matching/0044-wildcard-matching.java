class Solution {
    public boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();       
        int[][] dp = new int[n][m];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }     
        return f(n - 1, m - 1, p, s, dp);
    }
    
    private boolean f(int i, int j, String p, String s, int[][] dp) {
        if (i < 0 && j < 0) return true;
        if (i < 0 && j >= 0) return false;
        if (j < 0 && i >= 0) {
            for (int k = 0; k <= i; k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }      
        if (dp[i][j] != -1) {
            return dp[i][j] == 1 ? true : false;
        }
        if (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?') {
            boolean flag = f(i - 1, j - 1, p, s, dp);
            dp[i][j] = (flag == true) ? 1 : 0;
            return flag;
        }
        if (p.charAt(i) == '*') {
            boolean flag = f (i - 1, j, p, s, dp) || f (i, j - 1, p, s, dp);
            dp[i][j] = (flag == true) ? 1 : 0;
            return flag;
        }
        dp[i][j] = 0;
        return false;
    }
}
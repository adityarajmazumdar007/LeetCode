class Solution {
//    static int editDistanceUtil(String S1, String S2, int i, int j, int[][] dp) {
//         if (i == 0)
//             return j ;
//         if (j == 0)
//             return i ;
//         if (dp[i][j] != -1)
//             return dp[i][j];
//         if (S1.charAt(i-1) == S2.charAt(j-1))
//             return dp[i][j] = editDistanceUtil(S1, S2, i - 1, j - 1, dp);
//         else
//             return dp[i][j] = 1 + Math.min(editDistanceUtil(S1, S2, i - 1, j - 1, dp),
//                     Math.min(editDistanceUtil(S1, S2, i - 1, j, dp), editDistanceUtil(S1, S2, i, j - 1, dp)));
//     }
    public int minDistance(String S1, String S2) {
        int n = S1.length();
        int m = S2.length();

        int[][] dp = new int[n+1][m+1];
        for(int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for(int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(S1.charAt(i-1) == S2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], 
                    Math.min(dp[i][j-1], dp[i-1][j]));
                }
            }
        }

        return dp[n][m];
    }
}
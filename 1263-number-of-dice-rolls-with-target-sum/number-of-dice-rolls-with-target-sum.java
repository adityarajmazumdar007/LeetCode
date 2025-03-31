public class Solution {
    private final long M = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        int[][] t = new int[n + 1][target + 1];

        // t[i][j] = total ways to obtain j from exactly i dices

        t[0][0] = 1;
        
        for (int i = 1; i <= n; i++) { 
            for (int j = 1; j <= target; j++) { 

                for (int f = 1; f <= k; f++) {
                    if (f <= j) {
                        t[i][j] = (int) ((t[i][j] + t[i - 1][j - f]) % M);
                    }
                }
            }
        }

        return t[n][target];

    }
}
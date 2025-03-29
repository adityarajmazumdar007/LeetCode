import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;
    private int[][] dp;
    private int n;

    private int solve(int[] locations, int currCity, int finish, int fuel) {
        if (fuel < 0) 
            return 0;
        int ans = (currCity == finish) ? 1 : 0;
        
        if (dp[currCity][fuel] != -1) 
            return dp[currCity][fuel];


        for (int nextCity = 0; nextCity < n; nextCity++) {
            if (nextCity != currCity) {
                int remainingFuel = fuel - Math.abs(locations[currCity] - locations[nextCity]);
                ans = (ans + solve(locations, nextCity, finish, remainingFuel)) % MOD;
            }
        }

        return dp[currCity][fuel] = ans;
    }

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        n = locations.length;
        dp = new int[n][fuel + 1];

        for (int[] row : dp) 
            Arrays.fill(row, -1);

        return solve(locations, start, finish, fuel);
    }
}

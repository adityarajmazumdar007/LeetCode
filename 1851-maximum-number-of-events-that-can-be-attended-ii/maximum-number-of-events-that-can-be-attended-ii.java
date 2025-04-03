import java.util.*;

class Solution {
    private int n;
    private int[][] dp;

    private int solve(int[][] events, int i, int k) {
        if (k <= 0 || i >= n) 
            return 0;
        
        if (dp[i][k] != -1) 
            return dp[i][k];

        int start = events[i][0];
        int endt = events[i][1];
        int value = events[i][2];

        // Finding the next event which we can attend
        int nextIndex = findNextEvent(events, endt);

        int take = value + solve(events, nextIndex, k - 1);
        int skip = solve(events, i + 1, k);

        return dp[i][k] = Math.max(take, skip);
    }

    private int findNextEvent(int[][] events, int endt) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (events[mid][0] > endt) 
                right = mid - 1;
            else 
                left = mid + 1;
        }
        return left;
    }

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        
        n = events.length;
        dp = new int[n + 1][k + 1];

        for (int[] row : dp) 
            Arrays.fill(row, -1);
        
        return solve(events, 0, k);
    }
}


class Solution {
    private int[] dp;

    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return memoized(days, costs, n, 0);
    }

    private int memoized(int[] days, int[] costs, int n, int idx) {
        if (idx >= n) return 0; // No more travel days

        if (dp[idx] != -1) return dp[idx]; // Return cached result

        // Take 1-day pass
        int cost1 = costs[0] + memoized(days, costs, n, idx + 1);

        // Take 7-day pass
        int nextIdx7 = lowerBound(days, days[idx] + 7, idx, n);
        int cost7 = costs[1] + memoized(days, costs, n, nextIdx7);

        // Take 30-day pass
        int nextIdx30 = lowerBound(days, days[idx] + 30, idx, n);
        int cost30 = costs[2] + memoized(days, costs, n, nextIdx30);

        return dp[idx] = Math.min(cost1, Math.min(cost7, cost30));
    }

    // Binary Search to find the first index >= target
    private int lowerBound(int[] days, int target, int start, int n) {
        int left = start, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (days[mid] >= target) {
                right = mid - 1; // Move left to find the lower bound
            } else {
                left = mid + 1; // Move right
            }
        }
        return left; // First index where days[i] >= target
    }
}

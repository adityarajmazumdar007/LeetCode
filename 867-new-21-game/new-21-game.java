class Solution {
    public double new21GameMemo(int n, int k, int maxPts) {
        // Early stop: already stopped (k==0) or even the maximum possible final score <= n
        if (k == 0 || n >= k - 1 + maxPts) return 1.0;

        double[] memo = new double[k + maxPts + 1]; // store f(s) for s in [0, k-1 + maxPts]
        Arrays.fill(memo, -1.0);
        return f(0, n, k, maxPts, memo);
    }

    // f(s): probability we end with total <= n, starting from score s
    private double f(int s, int n, int k, int w, double[] memo) {
        // If we've stopped drawing, success iff final score <= n
        if (s >= k) return s <= n ? 1.0 : 0.0;

        if (memo[s] >= 0.0) return memo[s];

        double sum = 0.0;
        // Average over the next draw in [1..w]
        for (int d = 1; d <= w; d++) {
            sum += f(s + d, n, k, w, memo);
        }
        return memo[s] = sum / w;
    }

    // -------- Approach B: Bottom-Up with Sliding Window (Optimal) --------
    public double new21Game(int n, int k, int maxPts) {
        // If we never need to draw or the worst-case final score is still <= n → probability 1
        if (k == 0 || n >= k - 1 + maxPts) return 1.0;

        double[] dp = new double[n + 1];   // dp[i] = probability final score is exactly i
        dp[0] = 1.0;

        double window = 1.0;               // sum of dp[j] for j in [i-1 ... i-maxPts] but only with j < k
        double ans = 0.0;

        for (int i = 1; i <= n; i++) {
            dp[i] = window / maxPts;       // probability to reach exactly i
            if (i < k) {
                // Still below k → can continue drawing; contribute to future states
                window += dp[i];
            } else {
                // i >= k → terminal score; add to answer
                ans += dp[i];
            }
            // Remove the outdated left end of the window if it was a "continuing" state (<k)
            int left = i - maxPts;
            if (left >= 0 && left < k) {
                window -= dp[left];
            }
        }
        return ans; // sum of dp[k..n]
    }
}
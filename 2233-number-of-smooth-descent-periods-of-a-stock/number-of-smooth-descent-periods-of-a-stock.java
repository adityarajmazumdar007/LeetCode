class Solution {
    public long getDescentPeriods(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0L;
        }

        long ans = 1L;      // Day 0 itself is always a smooth descent period
        long currLen = 1L;  // Length of current smooth-descent run ending at i

        // Start from day 1 and build the run length
        for (int i = 1; i < prices.length; i++) {
            // If today is exactly 1 less than yesterday, extend the descent run
            if (prices[i - 1] - prices[i] == 1) {
                currLen++;
            } else {
                // Otherwise, the run breaks; only the single-day period exists ending at i
                currLen = 1L;
            }

            // Add number of periods ending at i (all suffixes of the current run)
            ans += currLen;
        }

        return ans;
    }
}
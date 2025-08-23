class Solution {
     private static int[][] costsGlobal;   // reference to input
    private static int nGlobal;           // number of houses
    private static int[][] memo;          // memo[i][c] = min cost from i if color c at i; -1 = uncomputed

    private static int f(int i, int c) {
        // Base: past last house
        if (i == nGlobal) return 0;

        // Memoized?
        if (memo[i][c] != -1) return memo[i][c];

        // Cost to paint current house i with color c
        int costHere = costsGlobal[i][c];

        // Next must be a different color
        int c1 = (c + 1) % 3;
        int c2 = (c + 2) % 3;

        // Recurrence: costHere + min of the two different-color continuations
        int bestNext = Math.min(f(i + 1, c1), f(i + 1, c2));

        return memo[i][c] = costHere + bestNext;
    }
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        if (costs[0] == null || costs[0].length != 3) {
            throw new IllegalArgumentException("Each row must have exactly 3 costs (R,B,G).");
        }

        // Initialize globals for recursion
        costsGlobal = costs;
        nGlobal = costs.length;
        memo = new int[nGlobal][3];
        for (int[] row : memo) Arrays.fill(row, -1);

        // Try starting with any color for house 0 and take the min
        int ans = Math.min(
            f(0, 0),
            Math.min(f(0, 1), f(0, 2))
        );
        return ans;
    }
}
class Solution {
    public int numSubmat(int[][] mat) {
         if (mat == null || mat.length == 0 || mat[0] == null || mat[0].length == 0) return 0;

        int m = mat.length, n = mat[0].length;
        int[] heights = new int[n]; // heights[c] = consecutive ones ending at current row
        long ans = 0L;

        for (int r = 0; r < m; r++) {
            // 1) Update histogram heights for this row
            for (int c = 0; c < n; c++) {
                heights[c] = (mat[r][c] == 1) ? (heights[c] + 1) : 0;
            }

            // 2) Monotonic stack of pairs (height, countOfColsMergedWithThisMin)
            Deque<int[]> stack = new ArrayDeque<>();
            long rowCount = 0L; // sum of minima over all subarrays ending at current column

            for (int c = 0; c < n; c++) {
                int h = heights[c];
                int merged = 1;

                // Maintain increasing heights; replace larger mins with smaller one
                while (!stack.isEmpty() && stack.peek()[0] >= h) {
                    int[] top = stack.pop();
                    // Remove previous contribution of those segments
                    rowCount -= (long) top[0] * top[1];
                    merged += top[1];
                }

                stack.push(new int[]{h, merged});
                // Add the new contribution: 'h' applies to 'merged' subarrays ending at c
                rowCount += (long) h * merged;

                // Accumulate: all rectangles ending at row r and column c
                ans += rowCount;
            }
        }
        return (int)ans;
    }
}
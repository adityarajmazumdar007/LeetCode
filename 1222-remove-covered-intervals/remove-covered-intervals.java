public class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];  // sort by start
            return b[1] - a[1];                   // if same start, sort by end descending
        });

        int count = 0;
        int end = 0;

        for (int[] interval : intervals) {
            if (interval[1] > end) {
                count++;         // not covered
                end = interval[1]; // update max end
            }
            // else: it's covered
        }

        return count;
    }
}

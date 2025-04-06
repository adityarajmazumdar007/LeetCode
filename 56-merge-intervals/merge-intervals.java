class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length; // size of the array

        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        List<int[]> mergedIntervals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mergedIntervals.isEmpty() || intervals[i][0] > mergedIntervals.get(mergedIntervals.size() - 1)[1]) {
                mergedIntervals.add(new int[]{intervals[i][0], intervals[i][1]});
            } else {
                mergedIntervals.get(mergedIntervals.size() - 1)[1] = Math.max(mergedIntervals.get(mergedIntervals.size() - 1)[1], intervals[i][1]);
            }
        }
        int[][] result = new int[mergedIntervals.size()][2];
        for (int i = 0; i < mergedIntervals.size(); i++) {
            result[i] = mergedIntervals.get(i);
        }

        return result;
    }
}
 
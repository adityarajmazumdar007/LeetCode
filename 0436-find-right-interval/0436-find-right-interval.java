class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;

        // Step 1: Create an array of [start, originalIndex]
        int[][] starts = new int[n][2];
        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0]; // start time
            starts[i][1] = i;               // original index
        }

        // Step 2: Sort the array by start time
        Arrays.sort(starts, Comparator.comparingInt(a -> a[0]));

        // Step 3: Prepare the result array
        int[] result = new int[n];

        // Step 4: For each interval, find the "right interval"
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];

            // Binary search for the smallest start >= end
            int left = 0, right = n - 1;
            int targetIndex = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (starts[mid][0] >= end) {
                    targetIndex = starts[mid][1]; // possible answer
                    right = mid - 1; // try to find even smaller start
                } else {
                    left = mid + 1;
                }
            }

            // Save the result
            result[i] = targetIndex;
        }

        return result;
    }
}
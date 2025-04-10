class SummaryRanges {
    private TreeSet<int[]> intervals;

    /** Initializes the object with an empty stream. */
    public SummaryRanges() {
        // Sort intervals by start time
        intervals = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
    }

    /** Adds the integer value to the stream. */
    public void addNum(int value) {
        // Create a dummy interval for searching
        int[] current = new int[]{value, value};

        // Find potential neighbors
        int[] prev = intervals.floor(current); // Interval ending at or before value
        int[] next = intervals.ceiling(current); // Interval starting at or after value

        // Check if value is already covered
        if (prev != null && prev[1] >= value) {
            return; // Already included in the 'prev' interval
        }

        boolean mergePrev = (prev != null && prev[1] + 1 == value);
        boolean mergeNext = (next != null && next[0] == value + 1);

        if (mergePrev && mergeNext) {
            // Merge all three: prev, value, next
            intervals.remove(prev);
            intervals.remove(next);
            intervals.add(new int[]{prev[0], next[1]});
        } else if (mergePrev) {
            // Merge value with prev
            intervals.remove(prev);
            intervals.add(new int[]{prev[0], value});
        } else if (mergeNext) {
            // Merge value with next
            intervals.remove(next);
            intervals.add(new int[]{value, next[1]});
        } else {
            // No merge, add as a new interval
            intervals.add(current);
        }
    }

    /** Returns a summary of the integers in the stream currently as a list of disjoint intervals. */
    public int[][] getIntervals() {
        int[][] result = new int[intervals.size()][2];
        int i = 0;
        for (int[] interval : intervals) {
            result[i++] = interval;
        }
        return result;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
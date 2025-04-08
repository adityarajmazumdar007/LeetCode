class Solution {
    public int minGroups(int[][] intervals) {
        TreeMap<Integer, Integer> timeline = new TreeMap<>();

        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            timeline.put(start, timeline.getOrDefault(start, 0) + 1);
            timeline.put(end + 1, timeline.getOrDefault(end + 1, 0) - 1);
        }

        int ongoing = 0, maxGroups = 0;
        for (int count : timeline.values()) {
            ongoing += count;
            maxGroups = Math.max(maxGroups, ongoing);
        }

        return maxGroups;
    }
}

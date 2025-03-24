class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 1;
        long right = (long) totalTrips * Arrays.stream(time).min().getAsInt();  // Max possible time

        while (left <= right) {
            long mid = left + (right - left) / 2;  // Middle time
            if (canCompleteTrips(time, totalTrips, mid)) {
                right = mid - 1;  // Try for a smaller time
            } else {
                left = mid + 1;  // Need more time
            }
        }
        return left;
    }

    private boolean canCompleteTrips(int[] time, int totalTrips, long currentTime) {
        long trips = 0;
        for (int t : time) {
            trips += currentTime / t;  
            if (trips >= totalTrips) return true; 
        }
        return false;
    }
}

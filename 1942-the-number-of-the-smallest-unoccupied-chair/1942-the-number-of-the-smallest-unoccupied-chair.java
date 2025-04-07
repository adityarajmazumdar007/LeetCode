class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        List<int[]> events = new ArrayList<>();

        // Record arrival and departure times
        for (int i = 0; i < n; i++) {
            events.add(new int[] {times[i][0], i});  // Arrival event
            events.add(new int[] {times[i][1], -1}); // Departure event
        }

        // Sort events by time
        events.sort((a, b) -> a[0] - b[0]);

        // Min-heap to track empty chairs
        PriorityQueue<Integer> emptyChairs = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            emptyChairs.add(i);
        }

        // Min-heap to track occupied chairs
        PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Process each event
        for (int[] event : events) {
            int time = event[0];
            int friendNo = event[1];

            // Free up chairs for friends who have departed
            while (!occupiedChairs.isEmpty() && occupiedChairs.peek()[0] <= time) {
                emptyChairs.add(occupiedChairs.poll()[1]);
            }

            if (friendNo >= 0) {  // Arrival event
                int chair = emptyChairs.poll();

                if (friendNo == targetFriend) {
                    return chair;
                }

                occupiedChairs.add(new int[] {times[friendNo][1], chair});
            }
        }

        return -1;  // Should not be reached
    }
}

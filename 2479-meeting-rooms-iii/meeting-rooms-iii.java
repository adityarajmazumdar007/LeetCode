
class Solution {
    /** Finds the room number that held the most meetings. */
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0])); // Sort by start time

        int[] roomCounts = new int[n];
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableRooms.offer(i);
        }
        // MinHeap stores {endTime, roomNumber}
        PriorityQueue<long[]> occupiedRooms = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1])
        );

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long duration = meeting[1] - start;

            // Free up finished rooms
            while (!occupiedRooms.isEmpty() && occupiedRooms.peek()[0] <= start) {
                availableRooms.offer((int) occupiedRooms.poll()[1]);
            }

            long meetingEndTime;
            int assignedRoom;

            if (!availableRooms.isEmpty()) {
                // Assign to earliest available room
                assignedRoom = availableRooms.poll();
                meetingEndTime = start + duration;
            } else {
                // Delay meeting: wait for the next room to free up
                long[] earliestFree = occupiedRooms.poll();
                long availableTime = earliestFree[0];
                assignedRoom = (int) earliestFree[1];
                meetingEndTime = availableTime + duration; // Start when room is free
            }

            roomCounts[assignedRoom]++;
            occupiedRooms.offer(new long[]{meetingEndTime, assignedRoom});
        }

        // Find room with max bookings (lowest index on tie)
        int maxBookings = -1;
        int resultRoom = -1;
        for (int i = 0; i < n; i++) {
            if (roomCounts[i] > maxBookings) {
                maxBookings = roomCounts[i];
                resultRoom = i;
            }
        }
        return resultRoom;
    }
}
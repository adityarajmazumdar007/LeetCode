import java.util.*;

public class Solution {
    public int maxEvents(int[][] events) {
        // Sort events by start day
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int day = 1, i = 0, n = events.length, res = 0;
        // Find the last day among all events
        int lastDay = 0;
        for (int[] event : events) lastDay = Math.max(lastDay, event[1]);
        
        for (day = 1; day <= lastDay; day++) {
            // Add all events that start today
            while (i < n && events[i][0] == day)
                minHeap.offer(events[i++][1]);
            // Remove events that have already expired
            while (!minHeap.isEmpty() && minHeap.peek() < day)
                minHeap.poll();
            // Attend event with the earliest end date
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                res++;
            }
        }
        return res;
    }
}

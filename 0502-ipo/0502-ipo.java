import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // Step 1: Store (capital, profit) pairs in a list
        List<int[]> projects = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
            projects.add(new int[]{capital[i], profits[i]});
        }

        // Step 2: Sort projects by the capital required (ascending order)
        Collections.sort(projects, Comparator.comparingInt(a -> a[0]));

        // Step 3: Use a Max Heap to store available project profits
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;  // Pointer for sorted projects

        // Step 4: Perform at most k project selections
        while (k-- > 0) {
            // Add all projects we can afford with current capital
            while (i < projects.size() && projects.get(i)[0] <= w) {
                maxHeap.add(projects.get(i)[1]); // Store profit
                i++;
            }

            // If no project is affordable, stop early
            if (maxHeap.isEmpty()) break;

            // Pick the most profitable project and increase capital
            w += maxHeap.poll();
        }

        // Return final capital after picking up to k projects
        return w;
    }
}

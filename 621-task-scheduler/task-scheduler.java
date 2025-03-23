class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }

        // Step 2: Max Heap to process the most frequent tasks first
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int freq : freqMap.values()) {
            maxHeap.add(freq);
        }

        // Step 3: Queue to track tasks waiting for their cooldown
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;

        // Step 4: Process tasks until both heap and queue are empty
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++; // Increment the timer

            // Process the most frequent task
            if (!maxHeap.isEmpty()) {
                int freq = maxHeap.poll() - 1; // Execute task, decrement count
                if (freq > 0) {
                    queue.add(new int[]{freq, time + n}); // Store remaining count and cooldown time
                }
            }

            // Check if any task in the queue is ready to be executed again
            if (!queue.isEmpty() && queue.peek()[1] == time) {
                maxHeap.add(queue.poll()[0]); // Reinsert into heap
            }
        }

        return time;
    }
}
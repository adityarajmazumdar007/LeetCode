
class Solution {
    static class Task {
        int startTime;
        int processingTime;
        int index;

        Task(int s, int p, int i) {
            this.startTime = s;
            this.processingTime = p;
            this.index = i;
        }
    }

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        List<Task> taskList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            taskList.add(new Task(tasks[i][0], tasks[i][1], i));
        }

        // Sort by enqueue time
        taskList.sort(Comparator.comparingInt(t -> t.startTime));

        PriorityQueue<Task> pq = new PriorityQueue<>(
            (a, b) -> a.processingTime == b.processingTime ? a.index - b.index : a.processingTime - b.processingTime
        );

        int[] result = new int[n];
        int idx = 0, resIdx = 0;
        long currTime = 0;

        while (idx < n || !pq.isEmpty()) {
            // If no tasks are available, jump time to the next available task
            if (pq.isEmpty() && currTime < taskList.get(idx).startTime) {
                currTime = taskList.get(idx).startTime;
            }

            while (idx < n && taskList.get(idx).startTime <= currTime) {
                pq.offer(taskList.get(idx));
                idx++;
            }

            Task currTask = pq.poll();
            currTime += currTask.processingTime;
            result[resIdx++] = currTask.index;
        }

        return result;
    }
}

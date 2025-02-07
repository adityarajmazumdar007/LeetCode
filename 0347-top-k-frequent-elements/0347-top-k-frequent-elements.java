

class Pair {
    int count;
    int element;

    Pair(int count, int element) {
        this.count = count;
        this.element = element;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.count - b.count);

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            Pair pair = new Pair(entry.getValue(), entry.getKey());
            minHeap.offer(pair);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] answer = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            answer[i] = minHeap.poll().element;
        }

        return answer;
    }
}

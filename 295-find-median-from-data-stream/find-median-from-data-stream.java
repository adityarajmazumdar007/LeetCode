import java.util.PriorityQueue;

class MedianFinder {

    // Max heap for the lower half
    private PriorityQueue<Integer> maxHeap;
    // Min heap for the upper half
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a); // maxHeap
        minHeap = new PriorityQueue<>(); // minHeap
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // Balance the heaps
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } 
        else if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } 
        else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } 
        else {
            return minHeap.peek();
        }
    }
}

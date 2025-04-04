import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            while (!deq.isEmpty() && deq.peekFirst() < i - k + 1) {
                deq.pollFirst();
            }

            // Remove elements that are smaller than the current element
            while (!deq.isEmpty() && nums[deq.peekLast()] < nums[i]) {
                deq.pollLast();
            }

            deq.offerLast(i); // Add current index to deque

            // Add the maximum element of the window to the result
            if (i >= k - 1) {
                result[i - k + 1] = nums[deq.peekFirst()];
            }
        }

        return result;
    }
}

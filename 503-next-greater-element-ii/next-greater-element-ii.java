import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Initialize the result array with -1 (default value)
        Arrays.fill(result, -1);

        // Iterate twice to handle the circular nature
        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n; // Circular index

            // Remove smaller elements from the stack
            while (!stack.isEmpty() && stack.peek() <= nums[idx]) {
                stack.pop();
            }

            // If stack is not empty, assign the next greater element
            if (!stack.isEmpty()) {
                result[idx] = stack.peek();
            }

            // Push the current element to stack
            stack.push(nums[idx]);
        }

        return result;
    }
}

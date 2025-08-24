class Solution {
     private static int f(int x, int a, int b, int c) {
        // Constraints are small (<=100), int is safe here
        return a * x * x + b * x + c;
    }
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) return new int[0];

        int n = nums.length;
        int[] res = new int[n];

        // Linear case can be handled by the same two-pointer logic,
        // but we short-circuit for clarity and tiny speed.
        if (a == 0) {
            if (b >= 0) {
                // f(x) = b*x + c is increasing on sorted nums -> fill in order
                for (int i = 0; i < n; i++) res[i] = f(nums[i], a, b, c);
            } else {
                // decreasing -> fill in reverse order to keep ascending output
                for (int i = 0; i < n; i++) res[i] = f(nums[n - 1 - i], a, b, c);
            }
            return res;
        }

        // Quadratic case with two pointers
        int l = 0, r = n - 1;
        if (a > 0) {
            // Convex: largest at the ends -> fill from the end
            int idx = n - 1;
            while (l <= r) {
                int leftVal = f(nums[l], a, b, c);
                int rightVal = f(nums[r], a, b, c);
                if (leftVal >= rightVal) {
                    res[idx--] = leftVal;
                    l++;
                } else {
                    res[idx--] = rightVal;
                    r--;
                }
            }
        } else {
            // Concave: smallest at the ends -> fill from the start
            int idx = 0;
            while (l <= r) {
                int leftVal = f(nums[l], a, b, c);
                int rightVal = f(nums[r], a, b, c);
                if (leftVal <= rightVal) {
                    res[idx++] = leftVal;
                    l++;
                } else {
                    res[idx++] = rightVal;
                    r--;
                }
            }
        }
        return res;
    }
}
class Solution {
    // Builds the maximal expression string without redundant parentheses.
    public String optimalDivision(int[] nums) {
        // Edge 1: Single number -> just that number.
        if (nums.length == 1) return String.valueOf(nums[0]);

        // Edge 2: Two numbers -> "a/b" (no need to wrap anything).
        if (nums.length == 2) return nums[0] + "/" + nums[1];

        // General case: a1 / (a2 / a3 / ... / an)
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append("/(");
        for (int i = 1; i < nums.length; i++) {
            if (i > 1) sb.append('/');
            sb.append(nums[i]);
        }
        sb.append(')');
        return sb.toString();
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        ans[0] = findBound(nums, target, true);  // Find first occurrence
        ans[1] = findBound(nums, target, false); // Find last occurrence
        return ans;
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int s = 0, e = nums.length - 1, result = -1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] == target) {
                result = m; 
                if (isFirst) e = m - 1; 
                else s = m + 1;  
            } else if (nums[m] > target) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return result;
    }
}

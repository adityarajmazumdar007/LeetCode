class Solution {
    public int minCapability(int[] nums, int k) {
        int left = 1, right = (int) 1e9, ans = (int) 1e9;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canSelect(nums, mid, k)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1; 
            }
        }
        return ans;
    }

    private boolean canSelect(int[] nums, int mid, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid) {
                count++;
                i++; 
            }
        }
        return count >= k;
    }
}

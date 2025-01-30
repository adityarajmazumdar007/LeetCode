class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1 || n == 0) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;
        
        int start = 1;
        int end = n - 2;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int current = nums[mid];
            int beforeMid = nums[mid - 1];
            int afterMid = nums[mid + 1];
            
            if (current > beforeMid && current > afterMid)
                return mid;
            else if (current < beforeMid)
                end = mid - 1;
            else
                start = mid + 1;
        }
        
        return -1;
    }
}

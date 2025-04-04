class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0;
        int j = 0;
        int longest = 0;
        int count = 0;
        while(j < nums.length) {
            if (nums[j] == 0) count++;
            while( count > 1) {
                if(nums[i] == 0) count--;
                i++;
            }
            longest = Math.max(longest, j - i + 1);
            j++;
        }
        return longest - 1;
    }
}
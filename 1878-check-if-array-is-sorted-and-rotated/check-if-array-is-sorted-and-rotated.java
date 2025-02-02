class Solution {
    public boolean check(int[] nums) {
        int countOfException = 0;
        int n = nums.length;
        for (int i =1; i< nums.length; i++) {
            if(nums[i] < nums[i-1]) countOfException++;
            if(countOfException > 1) return false;
        }
        if(nums[n-1] > nums[0] )countOfException++;
        return countOfException<=1;
    }
}
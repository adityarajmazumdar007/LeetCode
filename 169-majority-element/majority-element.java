class Solution {
    public int majorityElement(int[] nums) {
        int ele = -1;
        int count = 0;
        for (int i = 0; i< nums.length; i++) {
            if (count == 0) {
                count ++;
                ele = nums[i];
            }
            else if( ele == nums [i]) count++;
            else{
                count--;
            }
            
        }
        int c = 0;
        for (int i = 0; i< nums.length; i++) {
            if(nums[i] == ele) c++;
        }
        if (c> Math.ceil(nums.length/2)) return ele;
    return -1;
    }
}
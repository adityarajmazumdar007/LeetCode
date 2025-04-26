class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int mini=-1;
        int maxi=-1;
        int start=0;
        long count=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]<minK || nums[i]>maxK){
                start = i+1;
                mini = i;
                maxi = i;
                continue;
            }
            if(nums[i] == minK){
                mini = i;
            }
            if(nums[i] == maxK){
                maxi = i;
            }
            count+= (i-start+1) - (i - (Math.min(mini,maxi)+1)+1);
        }
        return count;
    }
}
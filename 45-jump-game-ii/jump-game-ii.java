class Solution {
    public int jump(int[] nums) {
        int coverage=0;
        int lastJumpIdx=0;
        int totalJumps=0;
        int destination = nums.length-1;
        if(destination==0)return 0;
        for(int i=0;i<nums.length;i++){
            coverage=Math.max(coverage,i+nums[i]);
            if(i==lastJumpIdx){
                lastJumpIdx=coverage;
                totalJumps++;
                if(lastJumpIdx>=destination)return totalJumps;
            }
        }
        return 0;
    }
}
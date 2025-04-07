class Solution {
    public boolean check(int index,int target,int[] nums, Boolean dp[][] ){
        if(target==0)return true;
        if(index==0)return target==nums[0];
        if(dp[index][target]!=null)return dp[index][target];
        Boolean notPick=check(index-1,target,nums,dp);
        boolean pick=false;
        if(nums[index]<=target)pick=check(index-1,target-nums[index],nums,dp);
        return dp[index][target]=pick||notPick;
    }
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2==1)return false;
        int target=sum/2;
        Boolean dp[][] = new Boolean[n][target+1];
        return check(n-1,target,nums,dp);
    }
}
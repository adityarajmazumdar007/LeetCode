class Solution {
    public int length(int index,int prevIdx,int length,int[] nums,int dp[][]){
        if(index==length)return 0;
        if(dp[index][prevIdx+1]!=-1)return dp[index][prevIdx+1];
        int notTake=0+length(index+1,prevIdx,length,nums,dp);
        int take=Integer.MIN_VALUE;
        if(prevIdx==-1 || nums[index]>nums[prevIdx]) take = 1+length(index+1,index,length,nums,dp);
        return dp[index][prevIdx+1]=Math.max(notTake,take);
        
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]= new int[n][n+1];
        for(int arr[]:dp){Arrays.fill(arr,-1);}
        return length(0,-1,n,nums,dp);
    }
}
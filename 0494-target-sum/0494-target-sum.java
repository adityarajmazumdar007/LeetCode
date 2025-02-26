class Solution {
public static int countWays(int index, int target, int[] arr,int dp[][]) {
        if (index == 0) {
            if ( target == 0 && arr[index]== 0 ) return 2;
            if ( target == 0 || target==arr[0] ) return 1;
            return 0;
        }
        if( dp[index][target]!=-1)return dp[index][target];
        int notPick=countWays(index-1,target,arr,dp);
        int pick=0;
        if(arr[index]<=target)pick=countWays(index-1,target-arr[index],arr,dp);
        return  dp[index][target]= pick+notPick;
    }
    public int findTargetSumWays(int[] arr, int d) {
        int n=arr.length;
        
        int tSum=0;
        for(int i=0;i<n;i++){tSum+=arr[i];}
        if( tSum-d <0 || (tSum-d)%2!=0)return 0;
        int target=(tSum-d)/2;
        int dp[][] = new int[n][target+1];
         for (int[] row : dp) Arrays.fill(row, -1);
        return countWays(n-1,target,arr,dp);
                                         
    }
}
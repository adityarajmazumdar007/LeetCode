class Solution {
    public static int countCoins(int[] coins,int amount,int index,int dp[][]){
        if(index==0){
            if(amount%coins[0]==0)return 1;
            return 0;
        }
        if( dp[index][amount]!=-1)return dp[index][amount];
        int notTake=countCoins(coins,amount,index-1,dp);
        int take=0;
        if(coins[index]<=amount){
            take=countCoins(coins,amount-coins[index],index,dp);
        }
        return dp[index][amount]=take+notTake;
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int dp[][] = new int[n][amount+1];
        for(int arr[]: dp){
            Arrays.fill(arr,-1);
        }
        return countCoins(coins,amount,n-1,dp);
    }
}

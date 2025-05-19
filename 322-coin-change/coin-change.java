class Solution {
    public int minCoins(int index,int amount,int []coins,int dp[][]){
        if (amount == 0) return 0;
        if(index==0){
            if(amount%coins[0]!=0)return (int)1e9;
            return amount/coins[0];
        }
        if(dp[index][amount]!=-1)return dp[index][amount];
        int notTake=0 + minCoins(index-1,amount,coins,dp);
        int take= (int)1e9;
        if(coins[index]<=amount)take= 1+minCoins(index,amount-coins[index],coins,dp);
        return dp[index][amount]=Math.min(take,notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][] = new int [n][amount+1];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        int ans= minCoins(n-1,amount,coins,dp);
        if(ans>=(int)1e9)return -1;
        return ans;
    }
}

class Solution {
    private static int solve(int[] cost,int n, int arr[]){
        if(n==0)return cost[0];
        if(n==1)return cost[1];
        if(arr[n]!=-1)return arr[n];
        arr[n]= cost[n]+Math.min(solve(cost,n-1,arr),solve(cost,n-2,arr));
        return arr[n];
    }
    
    public int minCostClimbingStairs(int[] cost) {
        int n= cost.length;
        int arr[] = new int[n];
        Arrays.fill(arr, -1);
        return Math.min(solve(cost,n-1,arr),solve(cost,n-2,arr));
    }
}
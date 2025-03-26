class Solution {
    int helper (int index, int canBuy, int lastIndex, int prices[], int fee, int arr [][]) {
        
        if (index == lastIndex) {
            return 0;

        }
        if (arr[index][canBuy] !=- 1) {
            return arr[index][canBuy];
        }
        int profit = 0;
        if (canBuy == 1) {
            profit = Math.max(-prices[index] + helper(index + 1, 0, lastIndex, prices, fee, arr),
                                helper(index + 1, 1, lastIndex, prices, fee, arr));
        } else {
             profit = Math.max(prices[index] - fee + helper(index + 1, 1, lastIndex, prices, fee, arr),
                                helper(index + 1, 0, lastIndex, prices, fee, arr));
        }
        return arr[index][canBuy] = profit;
    }
    public int maxProfit(int[] prices, int fee) {
        int arr [][] = new int[prices.length][2];
        for(int array[] : arr) {
            Arrays.fill(array,-1);
        }
        return helper (0, 1, prices.length, prices, fee, arr);
    }
}
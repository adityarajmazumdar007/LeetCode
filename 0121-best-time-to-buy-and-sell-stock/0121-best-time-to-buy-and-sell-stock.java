class Solution {
    public int maxProfit(int[] prices) {
        int minPrice=prices[0];
        int profit=0;
        for(int i=1;i<prices.length;i++){
            int cost=prices[i]-minPrice;
            profit=Math.max(profit,cost);
            minPrice=Math.min(minPrice,prices[i]);
        }
        return profit;
    }
}
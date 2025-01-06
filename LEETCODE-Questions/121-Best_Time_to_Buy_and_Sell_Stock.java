class Solution {
    // TC: O(N), SC; O(1)
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int profit = 0;
        int min = prices[0];

        for(int i=1; i<n; i++){
            int cost = prices[i] - min;
            profit = Math.max(profit, cost);
            // It comes under DP as we are storing the min price buy day
            min = Math.min(prices[i], min);
        }

        return profit;
    }
}
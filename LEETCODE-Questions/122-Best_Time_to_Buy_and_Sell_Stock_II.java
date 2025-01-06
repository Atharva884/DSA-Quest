class Solution {
    public int solve(int idx, int buy, int[] prices, int[][] dp){
        if(idx == prices.length) return 0;
        if(dp[idx][buy] != -1) return dp[idx][buy];

        int profit = 0;
        if(buy == 1){
            int take = -prices[idx] + solve(idx + 1, 0, prices, dp);
            int notTake = solve(idx + 1, 1, prices, dp);
            profit = Math.max(take, notTake);
        }else{
            int take = prices[idx] + solve(idx + 1, 1, prices, dp);
            int notTake = solve(idx + 1, 0, prices, dp);
            profit = Math.max(take, notTake);
        }

        return dp[idx][buy] = profit;
    }

    // TC: O(N * 2), SC: O(N * 2) + stack space
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }

        // At the 1st day, complete liberty of buying the stock
        return solve(0, 1, prices, dp);
    }
}
class Solution {
    public int solve(int idx, int buy, int[] prices, int n, int[][] dp){
        if(idx >= n) return 0;
        if(dp[idx][buy] != -1) return dp[idx][buy];

        if(buy == 1){
            int take = -prices[idx] + solve(idx+1, 0, prices, n, dp);
            int notTake = solve(idx+1, 1, prices, n, dp);

            return dp[idx][buy] = Math.max(take, notTake);
        }

        int take = prices[idx] + solve(idx+2, 1, prices, n, dp);
        int notTake = solve(idx+1, 0, prices, n, dp);

        return dp[idx][buy] = Math.max(take, notTake);
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }

        return solve(0, 1, prices, n, dp);
    }
}
class Solution {
    // public int solve(int idx, int buy, int[] prices, int n, int fee, int[][] dp){
    //     if(idx >= n) return 0;
    //     if(dp[idx][buy] != -1) return dp[idx][buy];

    //     if(buy == 1){
    //         int take = -prices[idx] + solve(idx+1, 0, prices, n, fee, dp);
    //         int notTake = solve(idx+1, 1, prices, n, fee, dp);

    //         return dp[idx][buy] = Math.max(take, notTake);
    //     }

    //     int take = (prices[idx] - fee) + solve(idx+1, 1, prices, n, fee, dp);
    //     int notTake = solve(idx+1, 0, prices, n, fee, dp);

    //     return dp[idx][buy] = Math.max(take, notTake);
    // }

    // Recursion + Memoization
    // TC: O(N*2), SC: O(N*2) + stack space
    // public int maxProfit(int[] prices, int fee) {
    //     int n = prices.length;
    //     int[][] dp = new int[n][2];
    //     for(int[] arr: dp){
    //         Arrays.fill(arr, -1);
    //     }

    //     return solve(0, 1, prices, n, fee, dp);
    // }

    // Tabulation
    // TC: O(N*2), SC: O(N*2) 
    // public int maxProfit(int[] prices, int fee){
    //     int n = prices.length;

    //     int[][] dp = new int[n+1][2];

    //     for(int idx=n-1; idx>=0; idx--){
    //         // Buy the stock
    //         int takeBuy = -prices[idx] + dp[idx+1][0];
    //         int notTakeBuy = dp[idx+1][1];

    //         dp[idx][1] = Math.max(takeBuy, notTakeBuy);

    //         // Sell the stock
    //         int takeSell = (prices[idx] - fee) + dp[idx+1][1];
    //         int notTakeSell = dp[idx+1][0];

    //         dp[idx][0] = Math.max(takeSell, notTakeSell);
    //     }

    //     return dp[0][1];
    // }

    public int maxProfit(int[] prices, int fee){
        int n = prices.length;

        int[] ahead = new int[2];
        int[] cur = new int[2];

        for(int idx = n-1; idx>=0; idx--){
            for(int buy=0; buy<=1; buy++){
                if(buy == 1){
                    int take = -prices[idx] + ahead[0];
                    int notTake = ahead[1];

                    cur[buy] = Math.max(take, notTake);
                }else{
                    int take = (prices[idx] - fee) + ahead[1];
                    int notTake = ahead[0];

                    cur[buy] = Math.max(take, notTake); 
                }
            }

            ahead = cur;
        }

        return ahead[1];
    }
}
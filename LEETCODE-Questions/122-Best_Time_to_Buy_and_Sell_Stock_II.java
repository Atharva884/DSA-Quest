class Solution {
    // public int solve(int idx, int buy, int[] prices, int[][] dp){
    //     if(idx == prices.length) return 0;
    //     if(dp[idx][buy] != -1) return dp[idx][buy];

    //     int profit = 0;
    //     if(buy == 1){
    //         int take = -prices[idx] + solve(idx + 1, 0, prices, dp);
    //         int notTake = solve(idx + 1, 1, prices, dp);
    //         profit = Math.max(take, notTake);
    //     }else{
    //         int take = prices[idx] + solve(idx + 1, 1, prices, dp);
    //         int notTake = solve(idx + 1, 0, prices, dp);
    //         profit = Math.max(take, notTake);
    //     }

    //     return dp[idx][buy] = profit;
    // }

    // TC: O(N * 2), SC: O(N * 2) + stack space
    // public int maxProfit(int[] prices) {
    //     int n = prices.length;
    //     int[][] dp = new int[n][2];
    //     for(int[] arr: dp){
    //         Arrays.fill(arr, -1);
    //     }

    //     // At the 1st day, complete liberty of buying the stock
    //     return solve(0, 1, prices, dp);
    // }

    // Tabulation -> { We removed the stack space which is used for recursion }
    // TC: O(N*2), SC: O(N*2)
    // public int maxProfit(int[] prices){
    //     int n = prices.length;

    //     int[][] dp = new int[n+1][2];
    //     // Base case
    //     dp[n][0] = dp[n][1] = 0;

    //     for(int idx=n-1; idx>=0; idx--){
    //         for(int buy=1; buy>=0; buy--){
    //             int profit = 0;

    //             if(buy == 1){
    //                 int take = -prices[idx] + dp[idx + 1][0];
    //                 int notTake = dp[idx+1][1];

    //                 profit = Math.max(take, notTake);
    //             }else{
    //                 int take = prices[idx] + dp[idx + 1][1];
    //                 int notTake = dp[idx+1][0];

    //                 profit = Math.max(take, notTake);
    //             }

    //             dp[idx][buy] = profit;
    //         }
    //     }

    //     return dp[0][1];
    // }

    // Optimal Approach -> In terms of space
    // TC: O(N*2), SC: O(4) -> 2 size array 
    public int maxProfit(int[] prices){
        int n = prices.length;

        int[] ahead = new int[2];
        int[] cur = new int[2];

        for(int idx=n-1; idx>=0; idx--){
            for(int buy=1; buy>=0; buy--){
                int profit = 0;

                if(buy == 1){
                    int take = -prices[idx] + ahead[0];
                    int notTake = ahead[1];

                    profit = Math.max(take, notTake);
                }else{
                    int take = prices[idx] + ahead[1];
                    int notTake = ahead[0];

                    profit = Math.max(take, notTake);
                }

                cur[buy] = profit;
            }
            ahead = cur;
        }

        return ahead[1];
    }
}
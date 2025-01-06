class Solution {
    // public int solve(int idx, int buy, int transaction, int[] prices, int[][][] dp){
    //     if(idx == prices.length || transaction == 2) return 0;
    //     if(dp[idx][buy][transaction] != -1) return dp[idx][buy][transaction];

    //     int profit = 0;
    //     if(buy == 1){
    //         int take = -prices[idx] + solve(idx + 1, 0, transaction, prices, dp);
    //         int notTake = solve(idx + 1, 1, transaction, prices, dp);
    //         profit = Math.max(take, notTake);
    //     }else{
    //         int take = prices[idx] + solve(idx + 1, 1, transaction+1, prices, dp);
    //         int notTake = solve(idx + 1, 0, transaction, prices, dp);
    //         profit = Math.max(take, notTake);
    //     }

    //     return dp[idx][buy][transaction] = profit;
    // }

    // // TC: O(N * 2 * 2), SC: O(N * 2 * 2) + stack space
    // public int maxProfit(int[] prices) {
    //     int n = prices.length;
    //     int[][][] dp = new int[n][2][2];
    //     for(int[][] arr: dp){
    //         for(int[] a: arr){
    //             Arrays.fill(a, -1);
    //         }
    //     }

    //     // At the 1st day, complete liberty of buying the stock
    //     return solve(0, 1, 0, prices, dp);
    // }

    // TC: O(N*2*3), SC: O(N*2*3)
    // public int maxProfit(int[] prices){
    //     int n = prices.length;

    //     int[][][] dp = new int[n+1][2][3];

    //     for(int idx=n-1; idx>=0; idx--){
    //         for(int buy=0; buy<=1; buy++){
    //             for(int cap=1; cap<=2; cap++){
    //                 int profit = 0;

    //                 if(buy == 1){
    //                     int take = -prices[idx] + dp[idx + 1][0][cap];
    //                     int notTake = dp[idx+1][1][cap];

    //                     profit = Math.max(take, notTake);
    //                 }else{
    //                     int take = prices[idx] + dp[idx + 1][1][cap-1];
    //                     int notTake = dp[idx+1][0][cap];

    //                     profit = Math.max(take, notTake);
    //                 }

    //                 dp[idx][buy][cap] = profit;
    //             }
    //         }
    //     }

    //     return dp[0][1][2];
    // }

    // TC: O(N*4), SC: O(N*4) + stack space
    public int solve(int idx, int transaction, int[] prices, int n, int[][] dp){
        if(idx == n || transaction == 4) return 0;
        if(dp[idx][transaction] != -1) return dp[idx][transaction];

        if(transaction % 2 == 0){
            // It's buy
            int take = -prices[idx] + solve(idx + 1, transaction + 1, prices, n, dp);
            int notTake = solve(idx+1, transaction, prices, n, dp);

            return dp[idx][transaction] = Math.max(take, notTake);
        }

        // It's sell
        int take = prices[idx] + solve(idx + 1, transaction + 1, prices, n, dp);
        int notTake = solve(idx+1, transaction, prices, n, dp);

        return dp[idx][transaction] = Math.max(take, notTake);
    }
    
    public int maxProfit(int[] prices){
        int n = prices.length;

        // B S B S
        // 0 1 2 3

        // if even then buy, else sell
        int[][] dp = new int[n][4];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }

        return solve(0, 0, prices, n, dp);
    }
}
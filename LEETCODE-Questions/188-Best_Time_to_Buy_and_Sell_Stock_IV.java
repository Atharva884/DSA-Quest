class Solution {
    // public int solve(int idx, int buy, int cap, int[] prices, int n, int k, int[][][] dp){
    //     if(idx == n || cap == 0) return 0;
    //     if(dp[idx][buy][cap] != -1) return dp[idx][buy][cap];

    //     if(buy == 1){
    //         int take = -prices[idx] + solve(idx + 1, 0, cap, prices, n, k, dp);
    //         int notTake = solve(idx+1, 1, cap, prices, n, k, dp);

    //         return dp[idx][buy][cap] = Math.max(take, notTake);
    //     }

    //     int take = prices[idx] + solve(idx + 1, 1, cap - 1, prices, n, k, dp);
    //     int notTake = solve(idx+1, 0, cap, prices, n, k, dp);

    //     return dp[idx][buy][cap] = Math.max(take, notTake);
    // }

    // Recursion + Memoization
    // TC: O(N*2*k), SC: O(N*2*K) + stack space
    // public int maxProfit(int k, int[] prices) {
    //     int n = prices.length;
    //     int[][][] dp = new int[n][2][k+1];
    //     for(int[][] arr: dp){
    //         for(int[] a: arr){
    //             Arrays.fill(a, -1);
    //         }
    //     }

    //     return solve(0, 1, k, prices, n, k, dp);
    // }

    // Tabulation
    // TC: O(N*2*k), SC: O(N*2*K)
    // public int maxProfit(int k, int[] prices){
    //     int n = prices.length;

    //     int[][][] dp = new int[n+1][2][k+1];

    //     // Base Case -> { Redundant as we are making it 0}
    //     // // cap base case
    //     // for(int idx=0; idx<=n; idx++){
    //     //     for(int buy=0; buy<=1; buy++){
    //     //         dp[idx][buy][0] = 0;
    //     //     }
    //     // }

    //     // // // idx base case
    //     // for(int cap=0; cap<=k; cap++){
    //     //     for(int buy=0; buy<=1; buy++){
    //     //         dp[n][buy][cap] = 0;
    //     //     }
    //     // }

    //     for(int idx=n-1; idx>=0; idx--){
    //         for(int buy=0; buy<=1; buy++){
    //             for(int cap=1; cap<=k; cap++){
    //                 if(buy == 1){
    //                     int take = -prices[idx] + dp[idx + 1][0][cap];
    //                     int notTake = dp[idx+1][1][cap];

    //                     dp[idx][buy][cap] = Math.max(take, notTake);
    //                 }else{
    //                     int take = prices[idx] + dp[idx + 1][1][cap - 1];
    //                     int notTake = dp[idx+1][0][cap];

    //                     dp[idx][buy][cap] = Math.max(take, notTake);
    //                 }
    //             }
    //         }
    //     }

    //     return dp[0][1][k];
    // }


    // public int solve(int idx, int trans, int[] prices, int n, int k, int[][] dp){
    //     if(idx == n || trans == 2*k) return 0;
    //     if(dp[idx][trans] != -1) return dp[idx][trans];

    //     if(trans % 2 == 0){
    //         int take = -prices[idx] + solve(idx + 1, trans + 1, prices, n, k, dp);
    //         int notTake = solve(idx + 1, trans, prices, n, k, dp);

    //         return dp[idx][trans] = Math.max(take, notTake);
    //     }

    //     int take = prices[idx] + solve(idx + 1, trans + 1, prices, n, k, dp);
    //     int notTake = solve(idx + 1, trans, prices, n, k, dp);

    //     return dp[idx][trans] = Math.max(take, notTake);
    // }

    // Another Approach -> (idx, transaction)
    // Recursion + Memoization
    // TC: O(N*2*k), SC: O(N*2*K) + stack space
    // public int maxProfit(int k, int[] prices){
    //     int n = prices.length;

    //     int[][] dp = new int[n][2*k];
    //     for(int[] arr: dp){
    //         Arrays.fill(arr, -1);
    //     }

    //     return solve(0, 0, prices, n, k, dp);
    // }

    // Another Approach (Using Tabulation) -> (idx, transaction)
    // TC: O(N*(2*k)), SC: O(N*(2*K))
    public int maxProfit(int k, int[] prices){
        int n = prices.length;

        int[][] dp = new int[n + 1][2*k + 1];

        for(int idx=n-1; idx>=0; idx--){
            for(int transaction=2 * k - 1; transaction>=0; transaction--){
                if(transaction % 2 == 0){
                    // Buy it
                    int take = -prices[idx] + dp[idx+1][transaction+1];
                    int notTake = dp[idx+1][transaction];

                    dp[idx][transaction] = Math.max(take, notTake);
                }else{
                    // Sell it
                    int take = prices[idx] + dp[idx+1][transaction+1];
                    int notTake = dp[idx+1][transaction];

                    dp[idx][transaction] = Math.max(take, notTake);
                }
            }
        }
        

        return dp[0][0];
    }
}
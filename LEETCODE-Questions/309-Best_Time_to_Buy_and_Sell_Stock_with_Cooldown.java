class Solution {
    // 

    // Recursion + Memoization
    // TC: O(N*2), SC: O(N*2) + stack space
    // public int maxProfit(int[] prices) {
    //     int n = prices.length;
    //     int[][] dp = new int[n][2];
    //     for(int[] arr: dp){
    //         Arrays.fill(arr, -1);
    //     }

    //     return solve(0, 1, prices, n, dp);
    // }


    // Tabulation
    // TC: O(N*2), SC: O(N*2) 
    public int maxProfit(int[] prices){
        int n = prices.length;

        int[][] dp = new int[n+2][2];

        for(int idx=n-1; idx>=0; idx--){
            for(int buy=0; buy<=1; buy++){
                if(buy == 1){
                    int take = -prices[idx] + dp[idx+1][0];
                    int notTake = dp[idx+1][1];

                    dp[idx][buy] = Math.max(take, notTake);
                }else{
                    int take = prices[idx] + dp[idx+2][1];
                    int notTake = dp[idx+1][0];

                    dp[idx][buy] = Math.max(take, notTake);
                }
            }
        }

        return dp[0][1];
    }
}
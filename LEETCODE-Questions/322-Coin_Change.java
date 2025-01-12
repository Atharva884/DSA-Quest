class Solution {

    // public int solve(int i, int k, int[] arr, int[][] dp){
    //     if(k == 0) return 0;
        
    //     // If we have exhausted all the coins or amount is neg
    //     if (i < 0 || k < 0) return (int) (1e9);

    //     if(dp[i][k] != -1) return dp[i][k];

    //     int x = solve(i-1, k, arr, dp);
    //     int y = (int) (1e9);

    //     if(k >= arr[i]){
    //         y = 1 + solve(i, k - arr[i], arr, dp);
    //     }

    //     return dp[i][k] = Math.min(x, y);
    // }

    // My Approach

    // Recursion + Memoization
    // TC: O(N*K), SC: O(N*K) + with stack space: O(N+K)

    // public int coinChange(int[] coins, int amount) {
    //     int n = coins.length;
    //     int[][] dp = new int[n][amount + 1];
    //     for(int[] arr: dp){
    //         Arrays.fill(arr, -1);
    //     }

    //     int res = solve(n-1, amount, coins, dp);

    //     return (res == (int) (1e9)) ? -1 : res;
    // }

    // public int solve(int i, int[] arr, int k, int[][] dp){
    //     if(i == 0){
    //         if(k % arr[0] == 0){
    //             return k / arr[0];
    //         }

    //         return (int) 1e9;
    //     }

    //     if(dp[i][k] != -1) return dp[i][k];

    //     int notTake = solve(i-1, arr, k, dp);
    //     int take = (int) 1e9;

    //     if(arr[i] <= k){
    //         take = 1 + solve(i, arr, k - arr[i], dp);
    //     }

    //     return dp[i][k] = Math.min(notTake, take);
    // }

    // Striver Approach
    // // Recursion + Memoization
    // // TC: O(N*K), SC: O(N*K) + with stack space: O(N+K)

    // public int coinChange(int[] coins, int k){
    //     int n = coins.length;
    //     int[][] dp = new int[n][k+1];
    //     for(int[] arr: dp){
    //         Arrays.fill(arr, -1);
    //     }

    //     int res = solve(n-1, coins, k, dp);

    //     if(res >= (int) 1e9) return -1;

    //     return res;
    // }

    // Tabulation
    // TC: O(N*K), SC: O(N*K)
    public int coinChange(int[] arr, int k){
        int n = arr.length;

        int[][] dp = new int[n][k + 1];

        for(int i=1; i<=k; i++){
            if(i % arr[0] == 0){
                dp[0][i] = i / arr[0];
            }else{
                dp[0][i] = (int) 1e9;
            }
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<=k; j++){
                int notTake = dp[i-1][j];
                int take = (int) 1e9;

                if(arr[i] <= j){
                    take = 1 + dp[i][j - arr[i]];
                }

                dp[i][j] = Math.min(take, notTake);
            }
        }

        return dp[n-1][k] >= (int) 1e9 ? -1 : dp[n-1][k];
    }
}
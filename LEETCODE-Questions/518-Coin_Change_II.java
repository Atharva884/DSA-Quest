class Solution {
    // public int solve(int i, int k, int[] arr, int[][] dp) {
    //     if (k == 0)
    //         return 1;

    //     if (i < 0 || k < 0)
    //         return 0;

    //     if (dp[i][k] != -1)
    //         return dp[i][k];

    //     int x = solve(i - 1, k, arr, dp);
    //     int y = 0;

    //     if (k >= arr[i]) {
    //         y = solve(i, k - arr[i], arr, dp);
    //     }

    //     return dp[i][k] = x + y;
    // }

    // // Recursion + Memoization
    // // TC: O(N*amount), SC: O(N*amount)
    // public int change(int amount, int[] coins) {
    //     int n = coins.length;
    //     int[][] dp = new int[n][amount + 1];
    //     for (int[] arr : dp) {
    //         Arrays.fill(arr, -1);
    //     }

    //     return solve(n - 1, amount, coins, dp);
    // }

    // public int solve(int i, int k, int[] arr, int[][] dp) {
    //     if (i == 0) {
    //         if (k % arr[0] == 0) {
    //             return 1;
    //         }
    //         return 0;
    //     }

    //     if (dp[i][k] != -1)
    //         return dp[i][k];

    //     int notTake = solve(i - 1, k, arr, dp);
    //     int take = 0;

    //     if (arr[i] <= k) {
    //         take = solve(i, k - arr[i], arr, dp);
    //     }

    //     return dp[i][k] = take + notTake;
    // }

    // // Recursion + Memoization
    // // TC: O(N*k), SC: O(N*k) with stack space: O(N+K)

    // public int change(int k, int[] coins) {
    //     int n = coins.length;

    //     int[][] dp = new int[n][k + 1];
    //     for (int[] arr : dp) {
    //         Arrays.fill(arr, -1);
    //     }

    //     return solve(n - 1, k, coins, dp);
    // }

    // Tabulation
    // TC: O(N*K), SC: O(N*K)
    public int change(int k, int[] arr) {
        int n = arr.length;

        int[][] dp = new int[n][k + 1];

        for (int i = 0; i <= k; i++) {
            if (i % arr[0] == 0) {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                int notTake = dp[i - 1][j];
                int take = 0;

                if (arr[i] <= j) {
                    take = dp[i][j - arr[i]];
                }

                dp[i][j] = take + notTake;
            }
        }

        return dp[n - 1][k];
    }
}
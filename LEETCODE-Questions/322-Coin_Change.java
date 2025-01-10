class Solution {
    public int solve(int i, int k, int[] arr, int[][] dp){
        if(k == 0) return 0;
        
        // If we have exhausted all the coins or amount is neg
        if (i < 0 || k < 0) return (int) (1e9);

        if(dp[i][k] != -1) return dp[i][k];

        int x = solve(i-1, k, arr, dp);
        int y = (int) (1e9);

        if(k >= arr[i]){
            y = 1 + solve(i, k - arr[i], arr, dp);
        }

        return dp[i][k] = Math.min(x, y);
    }

    // TC: O(N*amount), SC: O(N*amount)
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }

        int res = solve(n-1, amount, coins, dp);

        return (res == (int) (1e9)) ? -1 : res;
    }
}

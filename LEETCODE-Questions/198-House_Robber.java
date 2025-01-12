class Solution {
    // public int solve(int i, int[] arr, int[] dp){
    //     if(i < 0){
    //         return 0;
    //     }
        
    //     if(dp[i] != -1) return dp[i];
        
    //     int x = solve(i-1, arr, dp);
    //     int y = arr[i] + solve(i-2, arr, dp);
        
    //     return dp[i] = Math.max(x, y);
    // }

    // Recursion + Memoization
    // TC: O(N), SC: O(N) + stack space: O(N)
    // public int rob(int[] arr) {
    //     int n = arr.length;
    //     int[] dp = new int[n];
    //     Arrays.fill(dp, -1);
        
    //     return solve(n-1, arr, dp);   
    // }

    // Tabulation
    // TC: O(N), SC: O(N)
    public int rob(int[] arr){
        int n = arr.length;

        if(n == 1) return arr[0];

        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(dp[0], arr[1]);
        
        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-1], arr[i] + dp[i-2]);
        }
        
        return dp[n-1];
    }
}
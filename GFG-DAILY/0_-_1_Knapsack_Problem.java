class Solution {
    // static int solve(int i, int[] val, int[] weight, int k, int[][] dp){
    //     if(i < 0){
    //         return 0;
    //     }

    //     if(dp[i][k] != -1){
    //         return dp[i][k];   
    //     }
    
    //     int notPick = solve(i-1, val, weight, k, dp);
    //     int pick = 0;
    //     if(k >= weight[i]){
    //         pick = val[i] + solve(i-1, val, weight, k - weight[i], dp);
    //     }

    //     return dp[i][k] = Math.max(pick, notPick);        
    // }
    
    // Recursion + Memoization
    // TC: O(N*K), SC: O(N*K) with stack space: O(N+K)
    // static int knapSack(int capacity, int val[], int wt[]) {
    //     int n = val.length;
    //     int[][] dp = new int[n][capacity + 1];
        
    //     for(int[] arr: dp){
    //         for(int i=0; i<arr.length; i++){
    //             arr[i] = -1;
    //         }
    //     }
        
    //     return solve(n-1, val, wt, capacity, dp);
    // }
    
    // Tabulation
    // TC: O(N*K), SC: O(N*K)
    static int knapSack(int k, int[] val, int wt[]){
        int n = val.length;
        
        int[][] dp = new int[n][k + 1];
        
        // Base Case
        
        // Redundant
        // Cap == 0 -> We can't select any weight
        // for(int i=0; i<n; i++){
        //     dp[i][0] = 0;
        // }
        
        // For i == 0, can we select any weight
        for(int i=1; i<=k; i++){
            if(wt[0] <= i){
                dp[0][i] = val[0];
            }
        }
        
        // Main Logic
        for(int i=1; i<n; i++){
            for(int j=1; j<=k; j++){
                int np = dp[i-1][j];
                int p = 0;
                
                if(j >= wt[i]){
                    p = val[i] + dp[i-1][j - wt[i]];
                }
                
                dp[i][j] = Math.max(np, p);
            }
        }
        
        return dp[n-1][k];
    }
}

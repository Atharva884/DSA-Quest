// User function Template for Java

class Solution {
    static int solve(int i, int[] val, int[] weight, int k, int[][] dp){
        if(i < 0){
            return 0;
        }

        if(dp[i][k] != -1){
            return dp[i][k];   
        }
    
        int notPick = solve(i-1, val, weight, k, dp);
        int pick = 0;
        if(k >= weight[i]){
            pick = val[i] + solve(i, val, weight, k - weight[i], dp);
        }

        return dp[i][k] = Math.max(pick, notPick);        
    }
    
    static int knapSack(int val[], int wt[], int capacity) {
        int n = val.length;
        int[][] dp = new int[n][capacity + 1];
        
        for(int[] arr: dp){
            for(int i=0; i<arr.length; i++){
                arr[i] = -1;
            }
        }
        
        return solve(n-1, val, wt, capacity, dp);
    }
}
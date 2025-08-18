class Solution {
    public int brute(int[] arr, int i, int n, int k, int sum){
        if(i == n){
            return sum == k ? 1 : 0;
        }
        
        int pick = 0;
        if(arr[i] + sum <= k){
            pick = brute(arr, i+1, n, k, sum + arr[i]);
        }
        int notPick = brute(arr, i+1, n, k, sum);
        
        return pick + notPick;
    }
    
    
    public int optimal(int[] arr, int i, int n, int k, int sum, int[][] dp){
        if(i == n){
            return sum == k ? 1 : 0;
        }
        
        if(dp[i][sum] != -1) return dp[i][sum];
        
        int pick = 0;
        if(arr[i] + sum <= k){
            pick = optimal(arr, i+1, n, k, sum + arr[i], dp);
        }
        int notPick = optimal(arr, i+1, n, k, sum, dp);
        
        return dp[i][sum] = pick + notPick;
    }
    
    
    
    public int perfectSum(int[] arr, int k) {
        int n = arr.length;
        
        // Brute Approach - Using Only Recursion
        // TC: O(2^N), SC: O(N)
        // return brute(arr, 0, n, k, 0);
        
        
        // Optimal Approach
        // Recursion + Memoization 
        // TC: O(N*K), SC: O(N*K)
        
        int[][] dp = new int[n][k+1];
        for(int[] a: dp){
            Arrays.fill(a, -1);
        }
        
        return optimal(arr, 0, n, k, 0, dp);
    }
}

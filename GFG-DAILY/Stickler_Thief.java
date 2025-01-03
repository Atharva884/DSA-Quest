class Solution {
    public int solve(int i, int[] arr, int[] dp){
        if(i < 0){
            return 0;
        }
        
        if(dp[i] != -1) return dp[i];
        
        int x = solve(i-1, arr, dp);
        int y = arr[i] + solve(i-2, arr, dp);
        
        return dp[i] = Math.max(x, y);
    }
   
    public int findMaxSum(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return solve(n-1, arr, dp);
    }
}
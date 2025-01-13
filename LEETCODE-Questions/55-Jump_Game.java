class Solution {
    public boolean solve(int i, int[] arr, int n, Boolean[] dp){
        if(i == n-1) return true;

        if(dp[i] != null) return dp[i];

        for(int j=1; j<=arr[i]; j++){
            if(i + j < n){
                boolean ans = solve(i + j, arr, n, dp);
                if(ans) return dp[i] = true;
            }
        }

        return dp[i] = false;
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        Boolean[] arr = new Boolean[n];

        return solve(0, nums, n, arr);
    }
}
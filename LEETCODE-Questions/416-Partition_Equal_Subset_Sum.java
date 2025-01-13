class Solution {
    // public boolean solve(int i, int sm, int[] nums, int target, int[][] dp){
    //     if(sm == target) return true;

    //     if(i < 0) return false;

    //     if(dp[i][sm] != -1) return dp[i][sm] == 1 ? true : false;

    //     boolean x = solve(i-1, sm, nums, target, dp);
    //     boolean y = false;

    //     if(sm + nums[i] <= target){
    //         y = solve(i-1, sm + nums[i], nums, target, dp);
    //     } 

    //     dp[i][sm] = (x || y) ? 1 : 0;
    //     return (x || y);
    // }

    // Recursion + Memoization
    // TC: O(N*k), SC: O(N*k) + with stack space: O(N + k) where (k is sum / 2)

    // public boolean canPartition(int[] nums) {
    //     int n = nums.length;

    //     int sum = 0;
    //     for(int num: nums){
    //         sum += num;
    //     }

    //     if(sum % 2 != 0) return false;
    //     int[][] dp = new int[n][(sum/2) + 1];
    //     for(int[] arr: dp){
    //         Arrays.fill(arr, -1);
    //     }

    //     return solve(n-1, 0, nums, sum / 2, dp);
    // }

    // Tabulation
    // TC: O(N*k), SC: O(N*k) where (k is sum / 2)
    public boolean canPartition(int[] nums){
        int n = nums.length;

        int sum = 0;
        for(int num: nums) sum += num;

        if(sum % 2 == 1) return false;
        int k = sum / 2;

        int[][] dp = new int[n][k + 1];

        // Base Case
        for(int i=0; i<=k; i++){
            if(i == 0){
                dp[0][i] = 1;
                continue;
            }

            if(nums[0] == k) dp[0][i] = 1;
            else dp[0][i] = 0;
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<=k; j++){
                int notTake = dp[i-1][j];
                int take = 0;

                if(nums[i] <= j){
                    take = dp[i-1][j - nums[i]];
                }

                if(take == 1 || notTake == 1) dp[i][j] = 1;
                else dp[i][j] = 0;
            }
        }

        return dp[n-1][k] == 1 ? true : false;
    }
}
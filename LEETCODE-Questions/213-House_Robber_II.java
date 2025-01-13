class Solution {
    public int solve(int i, int[] arr, int choice, int[] dp){
        if(choice == 1){
            if(i < 1) return 0;
        }else{
            if(i < 0) return 0;
        }

        if(dp[i] != -1) return dp[i];

        int notTake = solve(i-1, arr, choice, dp);
        int take = arr[i] + solve(i-2, arr, choice, dp);

        return dp[i] = Math.max(notTake, take);
    }

    // Recursion + Memoization
    // TC: O(N), SC: O(N)
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int first = solve(n-1, nums, 1, dp);

        Arrays.fill(dp, -1);

        int second = solve(n-2, nums, 0, dp);

        return Math.max(first, second);
    }
}
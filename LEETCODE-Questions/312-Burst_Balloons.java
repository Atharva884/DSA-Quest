class Solution {
    // public int solve(int[] arr, int s, int e, int[][] dp){
    //     if(s + 1 >= e) return 0;
    //     if(dp[s][e] != -1) return dp[s][e];

    //     int ans = -1;
    //     for(int i=s+1; i<e; i++){
    //         int leftAns = solve(arr, s, i, dp);
    //         int rightAns = solve(arr, i, e, dp);
    //         int myAns = leftAns + rightAns + (arr[i] * arr[s] * arr[e]);

    //         ans = Math.max(myAns, ans);
    //     }

    //     return dp[s][e] = ans;
    // }

    // // Recursion + Memoization
    // // TC: O(N*N*N ~ N^3), SC: O(N*N) + stack space
    // public int maxCoins(int[] nums) {
    //     int n = nums.length;
    //     int[] arr = new int[n+2];
    //     Arrays.fill(arr, 1); // Just to avoid the edge cases

    //     for(int i=0; i<n; i++){
    //         arr[i+1] = nums[i];
    //     }

    //     int[][] dp = new int[n+2][n+2];
    //     for(int[] arr1: dp){
    //         Arrays.fill(arr1, -1);
    //     }

    //     return solve(arr, 0, n+1, dp);
    // }

    // Tabulation
    // TC: O(N*N*N), SC: O(N*N) -> { no stack space }
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n + 2][n + 2];

        int[] arr = new int[n + 2];
        Arrays.fill(arr, 1); // Just to avoid the edge cases

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        for (int gap = 2; gap < arr.length; gap++) {
            for (int s = 0; s < arr.length - gap; s++) {
                int e = s + gap;

                int ans = -1;
                for (int i = s + 1; i < e; i++) {
                    ans = Math.max(ans, dp[s][i] + dp[i][e] + (arr[i] * arr[s] * arr[e]));
                }

                dp[s][e] = ans;
            }
        }

        return dp[0][n + 1];
    }
}
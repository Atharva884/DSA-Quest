class Solution {
    public static int solve(int n, int[] dp){
        if(n == 1 || n == 2){
            return n;
        }

        if(dp[n] != -1) return dp[n];

        int a = solve(n-1, dp);
        int b = solve(n-2, dp);

        dp[n] = a + b;

        return a + b;
    }

    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return solve(n, dp);
    }
}

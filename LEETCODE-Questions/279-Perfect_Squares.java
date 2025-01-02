class Solution {
    public int solve(int n, int[] dp){
        if(n == 1 || n == 0){
            return n;
        }

        if(dp[n] != -1) return dp[n];

        int smallest = Integer.MAX_VALUE;
        for(int i=1; i * i <= n; i++){
            int temp = solve(n - i * i, dp);
            smallest = Math.min(temp, smallest);
        }

        return dp[n] = smallest + 1;
    }

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return solve(n, dp);
    }
}
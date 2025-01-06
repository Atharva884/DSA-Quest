class Solution {
    public int solve(String s1, int i, String s2, int j, int[][] dp){
        if (i < 0) {
            int sum = 0;
            for (int k = 0; k <= j; k++) {
                sum += (int) s2.charAt(k);
            }
            return sum;
        }
        if (j < 0) {
            int sum = 0;
            for (int k = 0; k <= i; k++) {
                sum += (int) s1.charAt(k);
            }
            return sum;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = solve(s1, i-1, s2, j-1, dp);
        }

        int x = (int) s1.charAt(i) + solve(s1, i-1, s2, j, dp);
        int y = (int) s2.charAt(j) + solve(s1, i, s2, j-1, dp);

        return dp[i][j] = Math.min(x, y);
    }

    // TC: O(N*M + O(n+m)), SC: O(N*M) + stack space
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }

        return solve(s1, n-1, s2, m-1, dp);
    }
}
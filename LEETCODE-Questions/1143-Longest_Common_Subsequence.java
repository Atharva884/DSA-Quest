class Solution {
    public int solve(String s1, int i, String s2, int j, int[][] dp){
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + solve(s1, i-1, s2, j-1, dp);
        }

        int x = solve(s1, i-1, s2, j, dp);
        int y = solve(s1, i, s2, j-1, dp);

        return dp[i][j] = Math.max(x, y);
    }


    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n][m];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }

        return solve(text1, n-1, text2, m-1, dp);
    }
}
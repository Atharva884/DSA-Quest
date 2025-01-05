class Solution {
    public int solve(String s1, int i, String s2, int j, int[][] dp){
        if(i < 0 && j < 0) return 0;
        if(i < 0) return j+1;
        if(j < 0) return i+1;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = solve(s1, i-1, s2, j-1, dp);
        }

        int x = 1 + solve(s1, i-1, s2, j, dp);
        int y = 1 + solve(s1, i, s2, j-1, dp);

        return dp[i][j] = Math.min(x, y);
    }

    // TC: O(N*M), SC: O(N*M) + stack space
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }

        return solve(word1, n-1, word2, m-1, dp);
    }
}
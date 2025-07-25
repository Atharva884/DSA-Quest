class Solution {
    // public int solve(String s1, int i, String s2, int j, int[][] dp){
    //     if(i < 0 || j < 0) return 0;
    //     if(dp[i][j] != -1) return dp[i][j];
        
    //     if(s1.charAt(i) == s2.charAt(j)){
    //         return dp[i][j] = 1 + solve(s1, i-1, s2, j-1, dp);
    //     }

    //     int x = solve(s1, i-1, s2, j, dp);
    //     int y = solve(s1, i, s2, j-1, dp);

    //     return dp[i][j] = Math.max(x, y);
    // }

    // // Recursive code
    // // TC: O(N * M), SC: O(N * M) + stack space
    // public int longestPalindromeSubseq(String s1) {
    //     StringBuilder sb = new StringBuilder(s1);
    //     String s2 = sb.reverse().toString();

    //     int n = s1.length();
    //     int m = s2.length();

    //     int[][] dp = new int[n][m];
    //     for(int[] arr: dp){
    //         Arrays.fill(arr, -1);
    //     }

    //     return solve(s1, n-1, s2, m-1, dp);
    // }

    public int longestPalindromeSubseq(String s1){
        StringBuilder sb = new StringBuilder(s1);
        String s2 = sb.reverse().toString();

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n][m];

        boolean hasRowMatch = false;
        for(int i=0; i<m; i++){
            if(s1.charAt(0) == s2.charAt(i)){
                hasRowMatch = true;
            }

            dp[0][i] = hasRowMatch ? 1 : 0; 
        }

        boolean hasColMatch = false;
        for(int i=0; i<m; i++){
            if(s1.charAt(i) == s2.charAt(0)){
                hasColMatch = true;
            }

            dp[i][0] = hasColMatch ? 1 : 0; 
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n-1][m-1];
    }
}
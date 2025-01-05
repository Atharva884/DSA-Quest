// User function Template for Java
class Solution {
    int solve(String s1, int i, String s2, int j, String s3, int k, int[][][] dp){
        if(i < 0 || j < 0 || k < 0) return 0;
        if(dp[i][j][k] != -1) return dp[i][j][k];
        
        
        if(s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k)){
            return dp[i][j][k] = 1 + solve(s1, i-1, s2, j-1, s3, k-1, dp);
        }
        
        int x = solve(s1, i-1, s2, j, s3, k, dp);
        int y = solve(s1, i, s2, j-1, s3, k, dp);
        int z = solve(s1, i, s2, j, s3, k-1, dp);
        
        return dp[i][j][k] = Math.max(Math.max(x, y), z);
    }
    
    // TC: O(N*M*O), SC: O(N*M*O)
    int LCSof3(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int o = s3.length();
        int[][][] dp = new int[n][m][o];
        
        for(int[][] arr: dp){
            for(int[] a: arr){
                Arrays.fill(a, -1);
            }
        }
        
        return solve(s1, n-1, s2, m-1, s3, o-1, dp);
    }
}
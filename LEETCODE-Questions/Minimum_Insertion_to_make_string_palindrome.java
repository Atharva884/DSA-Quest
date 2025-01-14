import java.util.*;

public class Solution {
    public static int solve(int i, String s1, int j, String s2, int[][] dp){
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return 1 + solve(i-1, s1, j-1, s2, dp);
        }

        return dp[i][j] = Math.max(solve(i-1, s1, j, s2, dp), solve(i, s1, j-1, s2, dp));
    }

    // Recursion + Memoization
    // TC: O(N*M), SC: O(N*M) with stack space: O(N+M)
    public static int minInsertion(String str) {
        int n = str.length();

        StringBuilder sb = new StringBuilder(str);

        int[][] dp = new int[n][n];
        for(int[] arr: dp) Arrays.fill(arr, -1);
        
        int LPS = solve(n-1, str, n-1, sb.reverse().toString(), dp);

        return n - LPS;
    }
}

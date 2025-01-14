import java.util.*;

public class Solution {
    public static int solve(int i, String s1, int j, String s2, int[][] dp){
        if(i < 0 && j < 0) return 0;

        if(i < 0){
            return j+1;
        }   

        if(j < 0){
            return i+1;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return solve(i-1, s1, j-1, s2, dp);
        }

        int ins = 1 + solve(i, s1, j-1, s2, dp);
        int del = 1 + solve(i-1, s1, j, s2, dp);

        return dp[i][j] = Math.min(ins, del);
    }

    // Recursion + Memoization
    // TC: O(N*M), SC: O(N*M) with stack space: O(N+M)
    public static int canYouMake(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n][m];
        for(int[] arr: dp) Arrays.fill(arr, -1);

        return solve(n-1, s1, m-1, s2, dp);
    }
}

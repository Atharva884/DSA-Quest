import java.util.*;

public class Solution {

    // public static int solve(int i, int j, String s1, String s2, int n, int m, StringBuilder sb, int[][] dp){
    //     if(i < 0 || j < 0) return 0;

    //     if(dp[i][j] != -1) return dp[i][j];

    //     if(s1.charAt(i) == s2.charAt(j)){
    //         sb.append(s1.charAt(i));
    //         return dp[i][j] = 1 + solve(i-1, j-1, s1, s2, n, m, sb, dp);
    //     }

    //     return dp[i][j] = Math.max(solve(i-1, j, s1, s2, n, m, sb, dp), solve(i, j-1, s1, s2, n, m, sb, dp));
    // }

    // Recursion + Memoization
    // TC: O(N*M), SC: O(N*M) + Stack space
    // public static String findLCS(int n, int m, String s1, String s2){
    //     StringBuilder sb = new StringBuilder();
    //     int[][] dp = new int[n][m];
    //     for(int[] arr: dp){
    //         Arrays.fill(arr, -1);
    //     }

    //     int ans = solve(n-1, m-1, s1, s2, n, m, sb, dp);

    //     return sb.reverse().toString();
    // }

    // Tabulation
    // TC: O(N*M), SC: O(N*M)
    public static String findLCS(int n, int m, String s1, String s2){
        int[][] dp = new int[n][m];

        boolean hasRowMatch = false;
        for(int i=0; i<n; i++){
            if(s1.charAt(i) == s2.charAt(0)){
                hasRowMatch = true;
            }
            dp[i][0] = hasRowMatch ? 1 : 0;
        }

        boolean hasColMatch = false;
        for(int i=0; i<m; i++){
            if(s1.charAt(0) == s2.charAt(i)){
                hasColMatch = true;
            }
            dp[0][i] = hasColMatch ? 1 : 0;
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

        int i = n-1;
        int j = m-1;
        StringBuilder sb = new StringBuilder();

        while(i >= 0 && j >= 0){
            if(s1.charAt(i) == s2.charAt(j)){
                sb.append(s1.charAt(i));
                i--;
                j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                i = i-1;
            }else{
                j = j-1;
            }
        }

        return sb.toString();
    }
}

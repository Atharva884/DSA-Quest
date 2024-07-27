import java.util.*;

class Solution {
    public int f(int s1, int s2, String text1, String text2, int[][] dp) {
        if (s1 < 0 || s2 < 0)
            return 0;
        if (dp[s1][s2] != -1)
            return dp[s1][s2];

        // If the chars are matching
        if (text1.charAt(s1) == text2.charAt(s2)) {
            return dp[s1][s2] = 1 + f(s1 - 1, s2 - 1, text1, text2, dp);
        }

        // If they aren't matching
        return dp[s1][s2] = Math.max(f(s1 - 1, s2, text1, text2, dp), f(s1, s2 - 1, text1, text2, dp));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int s1 = text1.length();
        int s2 = text2.length();
        int[][] dp = new int[s1][s2];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return f(s1 - 1, s2 - 1, text1, text2, dp);
    }
}
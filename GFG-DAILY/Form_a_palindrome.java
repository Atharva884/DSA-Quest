import java.util.*;

class Solution {
    // TC: O(N^2), SC: O(N^2)
    public static int LCS(String s1, String s2, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // If the characters matchs
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + LCS(s1, s2, i - 1, j - 1, dp);
        }

        // If the characters are not matching, then check for all the possibilites
        return dp[i][j] = Math.max(LCS(s1, s2, i - 1, j, dp), LCS(s1, s2, i, j - 1, dp));
    }

    static int countMin(String str) {
        int n = str.length();

        char[] arr = str.toCharArray();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int sp = 0;
        int ep = n - 1;

        while (sp <= ep) {
            char temp = arr[sp];
            arr[sp] = arr[ep];
            arr[ep] = temp;

            sp++;
            ep--;
        }

        String str1 = String.valueOf(arr);

        int ans = LCS(str, str1, n - 1, n - 1, dp);

        return n - ans;
    }
}
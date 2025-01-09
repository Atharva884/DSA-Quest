public class Solution {
    public static int lcs(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();

        int[][] dp = new int[n1][n2];

        int maxLen = 0;

        // Row wise
        for(int i=0; i<n1; i++){
            if(s1.charAt(i) == s2.charAt(0)){
                dp[i][0] = 1;
                maxLen = 1;
            }
        }

        // Col wise
        for(int i=0; i<n2; i++){
            if(s1.charAt(0) == s2.charAt(i)){
                dp[0][i] = 1;
                maxLen = 1;
            }
        }

        for(int i=1; i<n1; i++){
            for(int j=1; j<n2; j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    maxLen = Math.max(maxLen, dp[i-1][j-1] + 1);
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        return maxLen;
    }
}

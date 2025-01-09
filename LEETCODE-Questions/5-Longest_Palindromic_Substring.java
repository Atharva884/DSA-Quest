class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];
        int sp = 0;
        int maxLen = 1;

        for(int gap=0; gap<n; gap++){
            int i = 0;
            int j = gap;

            while(j < n){
                if(gap == 0){
                    dp[i][j] = true;
                }else if(gap == 1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                        int len = j - i + 1;
                        if(len > maxLen){
                            maxLen = len;
                            sp = i;
                        }
                    }
                }else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
                        dp[i][j] = true;
                        int len = j - i + 1;
                        if(len > maxLen){
                            maxLen = len;
                            sp = i;
                        }
                    }
                }

                i++;
                j++;
            }
        }

        return s.substring(sp, sp + maxLen);
    }
}
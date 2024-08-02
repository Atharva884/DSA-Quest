//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public static int solve(int i, int j, String str1, String str2, int[][] dp){
        // Base Cases
        
        // If the string 1 has been exhausted means i reaches less than 0 then we need 
        // to add j + 1 (bcoz, its a 0 based indexing) characters right.
        
        // Basically, If the string1 has no char left and we have to convert str1 to str2
        // then if str2 has some characters left then to convert str1 to str2 
        // it requires j + 1 (Insert Operation) 
        if(i < 0){
            return j + 1;
        }
        
        // If the string 2 has been exhausted means j reaches less than 0 then we need
        // to add i + 1 (bcoz, its a 0 based indexing) characters right.
        
        // Basically, If the string2 has no char left and we have to convert str1 to str2
        // then if str2 is "" then to convert str2 to "" it requires i + 1 
        // (Delete Operation)
        if(j < 0){
            return i + 1;
        }
        
        
        // Dp Part
        // If there are overlapping subproblems
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        
        // Main logic
        
        // In String matching, there are only two possibilities.
        
        // 1st Possibility --> {Matched}
        if(str1.charAt(i) == str2.charAt(j)){
            return dp[i][j] = solve(i-1, j-1, str1, str2, dp);
        }
        
        // 2nd possibility --> {Not Matched}
        int insertOp = 1 + solve(i, j-1, str1, str2, dp);
        int deleteOp = 1 + solve(i-1, j, str1, str2, dp);
        int replaceOp = 1 + solve(i-1, j-1, str1, str2, dp);
        
        // As we have to find the minimum operation we are trying all the ways and taking
        // the min op ways to solve our problem
        
        return dp[i][j] = Math.min(insertOp, Math.min(deleteOp, replaceOp));
    }
    
    
    public int editDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        
        // Initializing dp array and filling with -1
        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        
        return solve(n-1, m-1, str1, str2, dp);
    }
}
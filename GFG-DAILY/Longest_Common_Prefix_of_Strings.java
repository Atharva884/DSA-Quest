//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        StringBuilder sb = new StringBuilder(arr[0]);
        // System.out.println(sb.charAt(0));
        int n = arr.length;
        
        for(int i=1; i<n; i++){
            String str = arr[i];
            
            for(int j=0; j<str.length() && j < sb.length(); j++){
                if(str.charAt(j) != sb.charAt(j)){
                    sb.setLength(j); 
                    break;
                }
            }
        
        }
        
        return sb.toString().length() == 0 ? "-1" : sb.toString();
    }
}
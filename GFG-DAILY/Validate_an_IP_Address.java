//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Not Efficient
    
    
    // public static boolean isValid(String str) {
    //     // Split the array using dot(.) operator
    //     int n = str.length();
        
    //     if(n > 15){
    //         return false;
    //     }
        
    //     StringBuilder sb = new StringBuilder();
    //     int count = 0;
    //     for(int i=0; i<n; i++){
    //         char c = str.charAt(i);
            
    //         if(c - '0' >= 0 && c - '0' <= 9){
    //             sb.append(c);
    //         }else if(c == '.'){
    //             // If the dot's are at beg and end
    //             if(i == 0 || i == n-1){
    //                 return false;
    //             }
                
    //             count++;
                
    //             if(count > 3){
    //                 return false;
    //             }
                
    //             String strr = sb.toString();
    //             if(strr.length() != 0){
    //                 int num = Integer.parseInt(strr);

    //                 // Check if it is valid number 
    //                 if(num < 0 || num > 255){
    //                     return false;   
    //                 }
                    
    //                 // Check for leading zeroes
    //                 if(strr.length() > 1 && strr.charAt(0) == '0'){
    //                     return false;
    //                 }
                    
    //                 sb.setLength(0);
    //             }else{
    //                 // If there are no string between two dots
    //                 return false;
    //             }
    //         }
    //     }
        
    //     if(count != 3){
    //         return false;
    //     }
        
    //     // Check for the Last String
    //     String last = sb.toString();
    //     if(last.length() > 1 && last.charAt(0) == '0'){
    //         return false;
    //     }
        
    //     int lastElem = Integer.parseInt(last);
    //     if(lastElem < 0 || lastElem > 255){
    //         return false;   
    //     }
        
    //     return true;
    // }
    
    
    public static boolean isValid(String str){
        int dots = 0;
        int n = str.length();
        
        for(int i=0; i<n; i++){
            
            StringBuilder sb = new StringBuilder();
            
            // Appending the number in the SB until dot is encountered
            while(i < n && str.charAt(i) != '.'){
                sb.append(str.charAt(i));
                i++;
            }
            
            // If the num is not there between two dots and there are leading zeroes 
            // in the number
            if(sb.length() == 0 || sb.length() > 1 && sb.charAt(0) == '0') {
                return false;
            }
            
            if(i<n && str.charAt(i) == '.') dots++;
            if(Integer.parseInt(sb.toString()) > 255) return false;
        }
        
        return dots == 3;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
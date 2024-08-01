//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    // Naive Soln
    // TC: O(N*M), SC: O(1)
    
    // public int rowWithMax1s(int arr[][]) {
    //     int n = arr.length;
    //     int m = arr[0].length;
        
    //     int idx = -1;
    //     int max = 0;
        
    //     for(int i = 0; i<n; i++){
            
    //         int count = 0;
            
    //         for(int j=0; j<m; j++){
    //             if(arr[i][j] == 1){
    //                 count++;
    //             }
    //         }
            
    //         if(count > max){
    //             max = count;
    //             idx = i;
    //         }
            
    //     }
        
    //     return idx;
    // }

    // Better Soln than naive int term of computation
    
    // public int rowWithMax1s(int arr[][]) {
    //     int n = arr.length;
    //     int m = arr[0].length;
        
    //     int idx = -1;
    //     int max = 0;
        
    //     for(int i = 0; i<n; i++){
            
    //         int count = 0;
    //         int id1 = -1;
            
    //         for(int j=0; j<m; j++){
    //             if(arr[i][j] == 1){
    //                 id1 = j;
    //                 break;
    //             }
    //         }
            
    //         if(id1 != -1){
    //             count = ((m-1) - id1) + 1; 
    //         }
    //         // System.out.println(count);
            
    //         if(count > max){
    //             max = count;
    //             idx = i;
    //         }
            
    //     }
        
    //     return idx;
    // }
    
    
    // Optimal Soln
    // TC: O(n * log(m)), SC: O(1)
    public static int lowerBound(int[] arr, int m, int key){
        int lo = 0;
        int hi = m-1;
        int ans = m;
        
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            
            if(arr[mid] >= key){
                ans = mid;
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        
        return ans;
    }
    
    public int rowWithMax1s(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;
        int max = 0;
        int idx = -1;
        
        
        for(int i=0; i<n; i++){
            
            int count_ones = m - lowerBound(arr[i], m, 1);
            if(count_ones > max){
                max = count_ones;
                idx = i;
            }
        }
        
        return idx;
    }
    
}
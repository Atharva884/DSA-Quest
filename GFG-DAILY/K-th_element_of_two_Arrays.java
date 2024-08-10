//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] arr1 = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                arr1[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] arr2 = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                arr2[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(k, arr1, arr2));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Brute Force Approach
    // TC: O(N+M), SC: O(N+M)
    // public static int[] mergeTwoSortedArr(int[] arr1, int[] arr2){
    //     int n = arr1.length;
    //     int m = arr2.length;
        
    //     int[] sortArr = new int[n+m];
        
    //     int i = 0;
    //     int j = 0;
    //     int k = 0;
        
    //     while(i < n && j < m){
    //         if(arr1[i] < arr2[j]){
    //             sortArr[k++] = arr1[i];
    //             i++;
    //         }else{
    //             sortArr[k++] = arr2[j];
    //             j++;
    //         }
    //     }
        
    //     // If there are element left in arr1
    //     while(i < n){
    //         sortArr[k++] = arr1[i];
    //         i++;
    //     }
        
    //     while(j < m){
    //         sortArr[k++] = arr2[j];
    //         j++;
    //     }
        
    //     return sortArr;
    // }
    
    // public long kthElement(int k, int arr1[], int arr2[]) {
    //     int[] ans = mergeTwoSortedArr(arr1, arr2);
    //     int n = ans.length;
        
    //     if(k > n){
    //         return (long) -1;
    //     }
        
    //     long kth = ans[k-1];
        
    //     return kth;
    // }
    
    // Optimal Approach -> {In terms of space}
    // TC: Worst Case: O(N+M), SC: O(1)
    public static long mergeTwoSortedArr(int[] arr1, int[] arr2, int kIdx){
        int n = arr1.length;
        int m = arr2.length;
    
        int i = 0;
        int j = 0;
        int k = 1; // K starts from 1
    
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                
                if (k == kIdx) {
                    return arr1[i];
                }
                k++;
                i++;
            } else {
                
                if (k == kIdx) {
                    return arr2[j];
                }
                k++;
                j++;
            }
        }
    
        // If there are elements left in arr1
        while (i < n) {
            if (k == kIdx) {
                return arr1[i];
            }
            k++;
            i++;
        }
    
        // If there are elements left in arr2
        while (j < m) {
            if (k == kIdx) {
                return arr2[j];
            }
            k++;
            j++;
        }
    
        return -1;
    }
    
    public long kthElement(int k, int arr1[], int arr2[]) {
        long ans = mergeTwoSortedArr(arr1, arr2, k);
        
        return ans;
    }
}
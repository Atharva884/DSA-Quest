import java.io.*;
import java.util.*;

public class Solution {

    public static int brute(int[] arr){
        int n = arr.length;

        int sum = 0;
        for(int sp=0; sp<n; sp++){
            for(int ep=sp; ep<n; ep++){
                for(int i=sp; i<=ep; i++){
                    sum += arr[i];
                }   
            }
        }
        
        return sum;
    }

    public static int[] prefixSum(int[] arr){
        int n = arr.length;

        int[] pfSum = new int[n];
        pfSum[0] = arr[0];
        
        for(int i=1; i<n; i++){
            pfSum[i] = pfSum[i-1] + arr[i];
        }
        
        return pfSum;
    }
    
    public static int optimal(int[] arr){
        int n = arr.length;
        int[] pfSum = prefixSum(arr);
        
        int sum = 0;
        for(int sp=0; sp<n; sp++){
            for(int ep=sp; ep<n; ep++){
                // [sp, ep] is a subarray
                if(sp-1 < 0) sum += pfSum[ep];
                else sum += pfSum[ep] - pfSum[sp-1];
            }
        }
        
        return sum;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        
        // Brute Approach
        // TC: O(N^3), SC: O(1)
        // int ans = brute(arr);
        // System.out.println(ans);

        // Optimal Approach
        // TC: O(N) + O(N^2), SC: O(N)
        int ans = optimal(arr);
        System.out.println(ans);
    }
}

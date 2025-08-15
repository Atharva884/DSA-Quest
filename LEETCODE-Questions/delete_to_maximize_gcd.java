import java.io.*;
import java.util.*;

public class Solution {
    public static int gcd(int a, int b){
        if(a == 0) return b;
        
        int temp = gcd(b % a, a);
        
        return temp;
    }

    public static int brute(int[] arr, int n){
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++){
            int ans = 0;
            for(int j=0; j<n; j++){
                if(i == j) continue;
        
                ans = gcd(ans, arr[j]);
            }
            
            max = Math.max(max, ans);
        }
        
        return max;
    }
    
    public static int[] prefixGCD(int[] arr, int n){
        int[] pfGCD = new int[n];
        
        pfGCD[0] = arr[0];
        for(int i=1; i<n; i++){
            pfGCD[i] = gcd(pfGCD[i-1], arr[i]);
        }
        
        return pfGCD;
    }
    
    public static int[] suffixGCD(int[] arr, int n){
        int[] sfGCD = new int[n];
        
        sfGCD[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--){
            sfGCD[i] = gcd(sfGCD[i+1], arr[i]);
        }
        
        return sfGCD;
    }
    
    public static int optimal(int[] arr, int n){
        int[] pfGCD = prefixGCD(arr, n);
        int[] sfGCD = suffixGCD(arr, n);
        
        int max = Integer.MIN_VALUE;
        
        max = Math.max(max, sfGCD[1]);
        max = Math.max(max, pfGCD[n-2]);
        
        for(int i=1; i<n-1; i++){
            int ans = gcd(pfGCD[i-1], sfGCD[i+1]);
            
            max = Math.max(max, ans);
        }
        
        return max;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        
        // Brute Approach
        // TC: O(N^2 * log(max(a, b))), SC: O(logN) where n is max(a, b)
        // int ans = brute(arr, n);
        // System.out.println(ans);
        
        // Optimal Approach
        // TC: O(3N * log(max(a, b))) ~ O(Nlog(max(a, b))), SC: O(Nlog(max(a, b)))
        int ans = optimal(arr, n);
        System.out.println(ans);
    }
}

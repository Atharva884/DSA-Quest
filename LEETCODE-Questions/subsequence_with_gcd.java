import java.io.*;
import java.util.*;

public class Solution {
    public static int gcd(int a, int b){
        if(a == 0) return b;
        
        int temp = gcd(b % a, a);
        
        return temp;
    }    

    public static int gcdOfArray(int[] arr){
        int n = arr.length;
        
        int ans = 0;
        for(int i=0; i<n; i++){
            ans = gcd(ans, arr[i]);
        }
        
        return ans;
    }

    // Optimal Approach
    // TC: O(Nlog(max(a, b))), SC: logn where n is max(a, b)
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        
        int ans = gcdOfArray(arr);
        System.out.println(ans == 1 ? true : false);
    }
}

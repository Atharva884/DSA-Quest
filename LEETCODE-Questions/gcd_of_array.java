import java.io.*;
import java.util.*;

public class Solution {

    public static int gcd(int a, int b){
        if(a == 0) return b;

        int temp = gcd(b % a, a);
        
        return temp;
    }
    
    
    // Optimal Approach
    // TC: O(N*log(max(a, b))), SC: O(logN)
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        
        int ans = 0;
        for(int i=0; i<n; i++){
            ans = gcd(ans, arr[i]);
        }
        
        System.out.println(ans);
    }
}

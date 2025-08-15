import java.io.*;
import java.util.*;

public class Solution {

    public static int[] sieveOfErastothenes(int n){
        int[] arr = new int[n+1];
        for(int i=0; i<=n; i++){
            arr[i] = i;
        }
        
        arr[0] = 0;
        arr[1] = 1;
        
        for(int i=2; i <= n / i; i++){
            if(arr[i] == i){
                for(int j=i*i; j <= n; j+=i){
                    if(arr[j] == j){
                        arr[j] = i;
                    }
                }
            }
        }
        
        return arr;
    }

    // Optimal Approach
    // TC: O(NloglogN + Q * logN), SC: O(N)
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int q = scn.nextInt();
        
        int[] queries = new int[q];
        for(int i=0; i<q; i++){
            queries[i] = scn.nextInt();
        }
        
        int[] sieve = sieveOfErastothenes(n);
        
        for(int i=0; i<q; i++){
            int query = queries[i];
            
            int ans = query;
            while(ans > 1){
                System.out.print(sieve[ans] + " ");
                ans = ans / sieve[ans];
            }
            System.out.println();
        }
        
    }
}

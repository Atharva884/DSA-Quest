import java.io.*;
import java.util.*;

public class Solution {

    public static void merge(int[] arr, int s, int m, int e, int n){
        int[] ans = new int[e - s + 1];
        int k = 0;

        int i = s;
        int j = m+1;
        
        while(i <= m && j <= e){
            if(arr[i] < arr[j]){
                ans[k++] = arr[i++];
            }else{
                ans[k++] = arr[j++];
            }
        }

        while(i <= m){
            ans[k++] = arr[i++];
        }

        while(j <= e){
            ans[k++] = arr[j++];
        }
        
        for(int l=s; l<=e; l++){
            arr[l] = ans[l-s];
        }
    }

    // TC: O(N), SC: O(N) where N -> {e - s + 1}
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }

        int s = scn.nextInt();
        int m = scn.nextInt();
        int e = scn.nextInt();

        merge(arr, s, m, e, n);
        
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}

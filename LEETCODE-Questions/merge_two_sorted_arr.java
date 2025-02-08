import java.io.*;
import java.util.*;

public class Solution {

    public static void mergeTwoSortedArr(int[] a, int[] b, int n, int m){
        int i = 0;
        int j = 0;
        int k = 0;

        int[] ans = new int[n+m];

        while(i < n && j < m){
            if(a[i] < b[j]){
                ans[k++] = a[i];
                i++;
            }else{
                ans[k++] = b[j];
                j++;
            }
        }

        while(i < n){
            ans[k++] = a[i];
            i++;
        }

        while(j < m){
            ans[k++] = b[j];
            j++;
        }
        
        for(int l=0; l<n+m; l++){
            System.out.print(ans[l] + " ");
        }
    }

    // TC: O(N+M), SC: O(N+M)
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
    
        int[] a = new int[n];
        int[] b = new int[m];
        
        for(int i=0; i<n; i++){
            a[i] = scn.nextInt();
        }
        
        for(int i=0; i<m; i++){
            b[i] = scn.nextInt();
        }

        mergeTwoSortedArr(a, b, n, m);
    }
}

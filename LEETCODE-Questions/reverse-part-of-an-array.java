import java.io.*;
import java.util.*;

public class Solution {
    public static void swap(int[] arr, int sp, int ep){
        int temp = arr[sp];
        arr[sp] = arr[ep];
        arr[ep] = temp;
    }
    
    // TC: O(ep - sp), SC: O(1)
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        
        int sp = scn.nextInt();
        int ep = scn.nextInt();
        
        while(sp < ep){
            swap(arr, sp, ep);
            
            sp++;
            ep--;
        }
        
        for(int a: arr){
            System.out.print(a + " ");
        }
    }
}

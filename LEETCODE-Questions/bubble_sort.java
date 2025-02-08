import java.io.*;
import java.util.*;

public class Solution {

     public static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // TC: O(N^2), SC: O(1)
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    swap(j, j+1, arr);
                }
            }
        }
        
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}

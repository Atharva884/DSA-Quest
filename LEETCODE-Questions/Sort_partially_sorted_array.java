import java.io.*;
import java.util.*;

public class Solution {

    public static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // TC: O(N), SC: O(1)
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = scn.nextInt();
        }

        for(int i=N-1; i>0; i--){
            if(arr[i] < arr[i-1]){
                swap(i, i-1, arr);
            }            
        }
        
        for(int i=0; i<N; i++){
            System.out.print(arr[i] + " ");
        }
    }
}

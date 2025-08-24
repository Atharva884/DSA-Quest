import java.io.*;
import java.util.*;

public class Solution {

    public static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    // TC: O(N), SC: O(1)
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        
        int x = scn.nextInt();
        int y = scn.nextInt();

        swap(arr, x, y);
        
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}

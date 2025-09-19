import java.io.*;
import java.util.*;

public class Solution {

    // TC: O(N), SC: O(N)
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        
        int sp = scn.nextInt();
        int ep = scn.nextInt();

        for(int i=sp; i<=ep; i++){
            System.out.print(arr[i] + " ");
        }
    }
}

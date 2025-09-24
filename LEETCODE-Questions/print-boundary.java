import java.io.*;
import java.util.*;

public class Solution {

    public static void printBoundary(int[][] mat, int n){
        int i = 0;
        int j = 0;
        
        // Print Top boundary
        for(int k=0; k<n-1; k++){
            System.out.print(mat[i][j] + " ");
            j++;
        }
        
        // Print Right boundary
        for(int k=0; k<n-1; k++){
            System.out.print(mat[i][j] + " ");
            i++;
        }
        
        // Print Bottom boundary
        for(int k=0; k<n-1; k++){
            System.out.print(mat[i][j] + " ");
            j--;
        }
        
        // Print Left boundary
        for(int k=0; k<n-1; k++){
            System.out.print(mat[i][j] + " ");
            i--;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[][] mat = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                mat[i][j] = scn.nextInt();
            }
        }

        // TC: O(N), SC: O(1)
        printBoundary(mat, n);
    }
}

import java.io.*;
import java.util.*;

public class Solution {
    public static void swap(int[][] mat, int i, int j){
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }

    public static void transpose(int[][] mat, int n){
        
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                swap(mat, i, j);
            }
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
        
        // Optimal Approach
        // TC: O(N^2), SC: O(1)
        transpose(mat, n);

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}

import java.io.*;
import java.util.*;

public class Solution {
    // Optimal Approach
    // TC: O(N^2), SC: O(1)
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] mat = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                mat[i][j] = scn.nextInt();
            }
        }
        
        int i = 0;
        int j = 0;
        int steps = n-1;

        while(steps >= 1){
            
            // Top boundary
            for(int k=0; k<steps; k++){
                System.out.print(mat[i][j] + " ");
                j++;
            }
            
            // Right Boundary
            for(int k=0; k<steps; k++){
                System.out.print(mat[i][j] + " ");
                i++;
            }
            
            // Bottom Boundary
            for(int k=0; k<steps; k++){
                System.out.print(mat[i][j] + " ");
                j--;
            }
            
            // Left Boundary
            for(int k=0; k<steps; k++){
                System.out.print(mat[i][j] + " ");
                i--;
            }
            
            i++;
            j++;
            steps = steps - 2;
        }
        
        if(steps == 0){
            System.out.print(mat[i][j]);
        }
    }
}

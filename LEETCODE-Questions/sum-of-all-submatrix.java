import java.io.*;
import java.util.*;

public class Solution {

    public static int sumOfAllSubmatrix(int[][] mat, int n, int m){
        int sum = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int validSP = (i+1) * (j+1);
                int validEP = (n-i) * (m-j);

                sum += mat[i][j] * (validSP * validEP);
            }
        }
        
        return sum;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] mat = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                mat[i][j] = scn.nextInt();
            }
        }

        // TC: O(N*M), SC: O(1)
        int sum = sumOfAllSubmatrix(mat, n, m);
        System.out.println(sum);
    }
}

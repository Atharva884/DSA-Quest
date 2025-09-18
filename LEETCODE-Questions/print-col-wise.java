import java.io.*;
import java.util.*;

public class Solution {

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
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(mat[j][i] + " ");
            }
            System.out.println();
        }
    }
}

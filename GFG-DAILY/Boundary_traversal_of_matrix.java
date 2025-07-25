//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            s = in.readLine().trim().split(" ");
            int ind=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[ind++]);
                }
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.boundaryTraversal(a, n, m);
            for (int i : ans) {
                out.print(i + " ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return list of integers that form the boundary 
    //traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        int rSteps = n-1;
        int cSteps = m-1;
        
        if(rSteps >= 1 && cSteps >= 1){
            for(int k=0; k<cSteps; k++){
                arr.add(matrix[i][j]);
                j++;
            }
        
            for(int k=0; k<rSteps; k++){
                arr.add(matrix[i][j]);
                i++;
            }
            
            for(int k=0; k<cSteps; k++){
                arr.add(matrix[i][j]);
                j--;
            }
            
            for(int k=0; k<rSteps; k++){
                arr.add(matrix[i][j]);
                i--;
            }
        }
        
        
        
        if(cSteps == 0){
            for(int k=0; k<rSteps + 1; k++){
                arr.add(matrix[i][j]);
                i++;
            }
        }else if(rSteps == 0){
            for(int k=0; k<cSteps + 1; k++){
                arr.add(matrix[i][j]);
                j++;
            }
        }
        
        return arr;
    }
}

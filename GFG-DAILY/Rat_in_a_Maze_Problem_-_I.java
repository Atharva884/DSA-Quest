//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends




class Solution {
    public static void findPath(int i, int j, int[][] m, int n, String str, ArrayList<String> ans, int[][] vis){
        // If the rat has reached the destination
        if(i == n-1 && j == n-1 ){
            ans.add(str);
            return;
        }
        
        // We have to perform the recursion in this directions (DLRU)
        
        // Downward Dir
        if(i+1 < n && m[i+1][j] == 1 && vis[i+1][j] == 0){
            vis[i][j] = 1;
            findPath(i+1, j, m, n, str + 'D', ans, vis);
            vis[i][j] = 0;
        }
        
        // Left Dir
        if(j-1 >= 0 && m[i][j-1] == 1 && vis[i][j-1] == 0){
            vis[i][j] = 1;
            findPath(i, j-1, m, n, str + 'L', ans, vis);
            vis[i][j] = 0;
        }
        
        // Right Dir
        if(j+1 < n && m[i][j+1] == 1 && vis[i][j+1] == 0){
            vis[i][j] = 1;
            findPath(i, j+1, m, n, str + 'R', ans, vis);
            vis[i][j] = 0;
        }
        
        // Up Dir
        if(i-1 >= 0 && m[i-1][j] == 1 && vis[i-1][j] == 0){
            vis[i][j] = 1;
            findPath(i-1, j, m, n, str + 'U', ans, vis);
            vis[i][j] = 0;
        }
        
    }
    
    public ArrayList<String> findPath(int[][] mat) {
        int n = mat.length;
        ArrayList<String> ans = new ArrayList<>();
        
        int[][] vis = new int[n][n];
        
        for(int i=0; i<n; i++){
            Arrays.fill(vis[i], 0);
        }
        
        // If the rat is standing in the valid place
        if(mat[0][0] == 1){
            findPath(0, 0, mat, n, "", ans, vis);
        }
        
        
        return ans;
    }
}
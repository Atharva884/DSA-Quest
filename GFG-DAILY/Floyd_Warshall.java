// User function template for JAVA

class Solution {
    // TC: O(V^3), SC: O(1)
    public void shortestDistance(int[][] mat) {
        int n = mat.length;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == -1){
                    mat[i][j] = 10001;
                }
                
                if(i == j){
                    mat[i][j] = 0;
                }
            }
        }
        
        
        for(int via=0; via<n; via++){
            
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(mat[i][via] != 10001 && mat[i][via] != 0 && mat[via][j] != 10001 && mat[via][j] != 0){
                        mat[i][j] = Math.min(mat[i][j], mat[i][via] + mat[via][j]);
                    }
                }
            }
            
        }
        
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 10001){
                    mat[i][j] = -1;
                }
            }
        }
    }
}
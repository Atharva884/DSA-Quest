class Solution {
    // Optimal Approach
    // TC: O(N*M), SC: O(1)
    public List<Integer> spiralOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        List<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = 0;
        int rSteps = n-1;
        int cSteps = m-1;

        while(rSteps >= 1 && cSteps >= 1){

            // Top boundary
            for(int k=0; k<cSteps; k++){
                ans.add(mat[i][j]);
                j++;
            }
            
            // Right Boundary
            for(int k=0; k<rSteps; k++){
                ans.add(mat[i][j]);
                i++;
            }
            
            // Bottom Boundary
            for(int k=0; k<cSteps; k++){
                ans.add(mat[i][j]);
                j--;
            }
            
            // Left Boundary
            for(int k=0; k<rSteps; k++){
                ans.add(mat[i][j]);
                i--;
            }

            i++;
            j++;
            rSteps = rSteps - 2;
            cSteps = cSteps - 2;
        }

        if(rSteps == 0){
            for(int k=0; k<cSteps+1; k++){
                ans.add(mat[i][j]);
                j++;
            }
        }else if(cSteps == 0){
            for(int k=0; k<rSteps+1; k++){
                ans.add(mat[i][j]);
                i++;
            }
        }

        return ans;
    }
}

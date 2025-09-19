class NumMatrix {
    int[][] pfMat;

    public static void prefixRowWise(int[][] matrix, int[][] pfMat, int n, int m){
        
        for(int i=0; i<n; i++){
            pfMat[i][0] = matrix[i][0];

            for(int j=1; j<m; j++){
                pfMat[i][j] = pfMat[i][j-1] + matrix[i][j];
            }
        }
    }

    public static void prefixColWise(int[][] matrix, int[][] pfMat, int n, int m){
        for(int i=0; i<m; i++){
            for(int j=1; j<n; j++){
                pfMat[j][i] = pfMat[j-1][i] + pfMat[j][i];
            }
        }
    }

    // TC: O(2 * (N*M)) ~ O(N*M), SC: O(N*M)
    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        pfMat = new int[n][m];

        prefixRowWise(matrix, pfMat, n, m);

        prefixColWise(matrix, pfMat, n, m);
    }
    
    // TC: O(1), SC: O(1)
    public int sumRegion(int x1, int y1, int x2, int y2) {
        int ans = pfMat[x2][y2];

        if(x1 - 1 >= 0){
            ans = ans - pfMat[x1-1][y2];
        }

        if(y1 - 1 >= 0){
            ans = ans - pfMat[x2][y1-1];
        }

        if(x1 - 1 >= 0 && y1 - 1 >= 0){
            ans = ans + pfMat[x1-1][y1-1];
        }

        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

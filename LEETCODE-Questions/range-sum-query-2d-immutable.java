// Brute Approach
// class NumMatrix {
//     int[][] mat;
//     // TC: O(N*M), SC: O(N*M)
//     public NumMatrix(int[][] matrix) {
//         int n = matrix.length;
//         int m = matrix[0].length;
//         mat = new int[n][m];

//         for(int i=0; i<n; i++){
//             for(int j=0; j<m; j++){
//                 mat[i][j] = matrix[i][j];
//             }
//         }
//     }
    
//     // Worst case: where all operations are row1,col1 = (0, 0) and row2,col2 = (n-1, m-1)
//     // TC: O(N*M), SC: O(1)
//     public int sumRegion(int row1, int col1, int row2, int col2) {
//         int sum = 0;
//         for(int i=row1; i<=row2; i++){
//             for(int j=col1; j<=col2; j++){
//                 sum += mat[i][j];
//             }
//         }

//         return sum;
//     }
// }

// Optimal Approach
class NumMatrix {
    int[][] mat;

    // TC: O(N*M), SC: O(N*M)
    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        mat = new int[n][m];

        // Prefix Sum on Row
        for(int i=0; i<n; i++){
            int sum = matrix[i][0];
            mat[i][0] = sum;
            for(int j=1; j<m; j++){
                sum += matrix[i][j];
                mat[i][j] = sum;
            }
        }

        // Prefix Sum on Col
        for(int i=0; i<m; i++){
            int sum = mat[0][i];
            for(int j=1; j<n; j++){
                sum += mat[j][i];
                mat[j][i] = sum;
            }
        }       
    }
    
    // TC: O(1), SC: O(1)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = mat[row2][col2];

        if(row1 - 1 >= 0){
            ans -= mat[row1-1][col2];
        }

        if(col1 - 1 >= 0){
            ans -= mat[row2][col1-1];
        }

        if(row1-1 >= 0 && col1-1 >= 0){
            ans += mat[row1-1][col1-1];
        }

        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

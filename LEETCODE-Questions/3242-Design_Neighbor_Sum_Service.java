class neighborSum {
    int[][] mat;
    int n;
    public neighborSum(int[][] grid) {
        this.mat = grid;
        this.n = grid.length;
    }
    
    public int adjacentSum(int value) {

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == value){
                    // We have i and j of the val respectively
                    int sum = 0;
                    sum += (j - 1 >= 0) ? mat[i][j - 1] : 0; // Check left
                    sum += (j + 1 < n) ? mat[i][j + 1] : 0;  // Check right
                    sum += (i - 1 >= 0) ? mat[i - 1][j] : 0; // Check top
                    sum += (i + 1 < n) ? mat[i + 1][j] : 0;  // Check bottom

                    return sum;
                }
            }
        }

        return -1;
    }
    
    public int diagonalSum(int value) {
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == value){
                   int sum = 0;

                    sum += (i - 1 >= 0 && j - 1 >= 0) ? mat[i - 1][j - 1] : 0; // Check top-left
                    sum += (i - 1 >= 0 && j + 1 < n) ? mat[i - 1][j + 1] : 0;  // Check top-right
                    sum += (i + 1 < n && j - 1 >= 0) ? mat[i + 1][j - 1] : 0;  // Check bottom-left
                    sum += (i + 1 < n && j + 1 < n) ? mat[i + 1][j + 1] : 0;  // Check bottom-right

                    return sum;
                }
            }
        }

        return -1;
    }
}

/**
 * Your neighborSum object will be instantiated and called as such:
 * neighborSum obj = new neighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */
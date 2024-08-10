class Solution {
    // Row Sum
    // TC: O(1) as it iterates over fixed 3*3
    public static int rowSum(int[][] grid, int r, int c){
        int sum = 0;
        boolean[] vis = new boolean[10];

        for(int i=0; i<3; i++){
            int rowSum = 0;
            for(int j=0; j<3; j++){
                int val = grid[r+i][c+j];

                // We need to check whether the val lies between 1 to 9 and the value
                // should be distinct (unique)
                if(val == 0 || val >= 10 || vis[val]){
                    return -1;
                }

                vis[val] = true;
                rowSum += val;
            }

            // If it is first row, then update the sum value so that we can compare
            if(i == 0){
                sum = rowSum;
            }else{
                if(rowSum != sum){
                    return -1;
                }
            }
        }

        return sum;
    }

    // Column Sum
    // TC: O(1) as it iterates over fixed 3*3
    public static int colSum(int[][] grid, int r, int c){
        int sum = 0;

        for(int j=0; j<3; j++){
            int colSum = 0;
            for(int i=0; i<3; i++){
                int val = grid[r+i][c+j];
                colSum += val;
            }

            // If it is first row, then update the sum value so that we can compare
            if(j == 0){
                sum = colSum;
            }else{
                if(colSum != sum){
                    return -1;
                }
            }
        }

        return sum;
    }

    // Diagonal Sum
    // TC: O(1)
    public static int diagonalSum(int[][] grid, int r, int c){
        int sum1 = grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2];
        int sum2 = grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c];

        if(sum1 == sum2){
            return sum1;
        }

        return -1;
    }

    // TC: O(1)
    public static boolean isMagicSquare(int[][] grid, int r, int c){
        int rowSum = rowSum(grid, r, c);
        if(rowSum == -1) return false;

        int colSum = colSum(grid, r, c);
        if(colSum == -1) return false;

        int diagonalSum = diagonalSum(grid, r, c);
        if(diagonalSum == -1) return false;

        if(rowSum == colSum && rowSum == diagonalSum){
            return true;
        }

        return false;
    }

    // Overall TC: O(n*m)
    // Overall SC: O(1)
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        // We are going n-2 and m-2 bcoz we want 3*3 matrix.
        // Handling bounding cases also
        for(int i=0; i<n-2; i++){
            for(int j=0; j<m-2; j++){
                if(isMagicSquare(grid, i, j)){
                    count++;
                }
            }
        }   

        return count;
    }
}
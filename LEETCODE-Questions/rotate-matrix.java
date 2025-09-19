class Solution {
    public static void swap(int[][] mat, int i, int j){
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }

    public static void transpose(int[][] mat, int n){
        
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                swap(mat, i, j);
            }
        }
    }

    public static void reverse(int[] mat, int n){
        int i = 0;
        int j = n-1;

        while(i < j){
            int temp = mat[i];
            mat[i] = mat[j];
            mat[j] = temp;

            i++;
            j--;
        }
    }

    public static void rotate(int[][] mat, int n){
        for(int i=0; i<n; i++){
            reverse(mat[i], n);
        }
    }

    // TC: O(2 * N^2) ~ O(N^2), SC: O(1)
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        transpose(matrix, n);

        rotate(matrix, n);
    }
}

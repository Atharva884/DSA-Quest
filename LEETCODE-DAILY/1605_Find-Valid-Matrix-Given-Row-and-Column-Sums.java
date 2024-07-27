class Solution {

    // public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
    // int n = rowSum.length;
    // int m = colSum.length;
    // int arr[][] = new int[n][m];
    // for (int i = 0; i < n; i++) {
    // int currRSum = rowSum[i];
    // for (int j = 0; j < m; j++) {
    // int currCSum = colSum[j];
    // if (currRSum == 0) {
    // arr[i][j] = 0;
    // continue;
    // }
    // if (currCSum >= currRSum) {
    // arr[i][j] = currRSum;
    // currCSum -= currRSum;
    // currRSum = 0;
    // } else {
    // arr[i][j] = currCSum;
    // currRSum -= currCSum;
    // currCSum = 0;
    // }
    // colSum[j] = currCSum;
    // }
    // }
    // return arr;

    // }

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;

        int[][] mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= mat[i][j];
                colSum[j] -= mat[i][j];
            }
        }

        return mat;
    }
}
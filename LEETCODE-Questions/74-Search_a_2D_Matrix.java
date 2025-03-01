class Solution {
    // Brute Approach
    // TC: O(N*M), SC: O(1)
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     int n = matrix.length;
    //     int m = matrix[0].length;

    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(matrix[i][j] == target) return true;
    //         }
    //     }

    //     return false;
    // }

    // public boolean bs(int[] arr, int target){
    //     int n = arr.length;
    //     int lo = 0;
    //     int hi = n - 1;

    //     while(lo <= hi){
    //         int m = lo + ((hi - lo) >> 1);

    //         if(arr[m] == target){
    //             return true;
    //         }else if(arr[m] > target){
    //             hi = m - 1;
    //         }else{
    //             lo = m + 1;
    //         }
    //     }

    //     return false;
    // }

    // Better Approach
    // TC: O(n) + O(logM), SC: O(1)
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     int n = matrix.length;
    //     int m = matrix[0].length;

    //     for(int i=0; i<n; i++){
    //         if(target >= matrix[i][0] && target <= matrix[i][m-1]){
    //             // If there then perform bs
    //             return bs(matrix[i], target);
    //         }
    //     }

    //     return false;
    // }

    // Optimal Approach
    // TC: O(log(n * m)), SC: O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int lo = 0;
        int hi = n * m - 1;

        while(lo <= hi){
            int mid = lo + ((hi - lo) >> 1);

            int row = mid / m;  // i 
            int col = mid % m;  // j

            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }

        return false;
    }
}
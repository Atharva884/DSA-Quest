class Solution {
    public int maxOfCol(int[][] mat, int mid, int n, int m){
        int max = Integer.MIN_VALUE;
        int row = -1;

        for(int i=0; i<n; i++){
            if(mat[i][mid] > max){
                max = mat[i][mid];
                row = i;
            }
        }

        return row;
    }

    // Optimal Approach
    // TC: O(logm * O(N)), SC: O(1)
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int lo = 0;
        int hi = m-1;

        while(lo <= hi){
            int mid = lo + ((hi - lo) >> 1);

            int row = maxOfCol(mat, mid, n, m);

            int left = mid - 1 >= 0 ? mat[row][mid-1] : -1;
            int right = mid + 1 < m ? mat[row][mid+1] : -1;

            if(mat[row][mid] > left && mat[row][mid] > right){
                return new int[]{row, mid};
            }else if(mat[row][mid] < left){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        
        return new int[]{-1, -1};
    }
}
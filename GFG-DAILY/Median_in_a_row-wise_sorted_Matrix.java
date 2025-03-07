// User function Template for Java

class Solution {
    int upperBound(int[] arr, int x){
        int n = arr.length;
        
        int lo = 0;
        int hi = n-1;
        int ans = n;
        
        while(lo <= hi){
            int m = lo + ((hi - lo) >> 1);
            
            if(arr[m] > x){
                ans = m;
                hi = m - 1;
            }else{
                lo = m + 1;
            }
        }
        
        return ans;
    }
    
    int cal(int[][] mat, int val){
        int n = mat.length;
        int m = mat[0].length;
        
        int sum = 0;
        
        for(int i=0; i<n; i++){
            int x = upperBound(mat[i], val);
            sum += x;
        }
        
        return sum;
    }
    
    // TC: O(log(max - min) * nlogM), SC: O(1)
    int median(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++){
            min = Math.min(min, mat[i][0]);
            max = Math.max(max, mat[i][m-1]);
        }
        
        int lo = min;
        int hi = max;
        
        int req = (n * m) / 2;
        
        while(lo <= hi){
            int mid = lo + ((hi - lo) >> 1);
            
            int elems = cal(mat, mid);
            
            if(elems <= req){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        
        return lo;
    }
}
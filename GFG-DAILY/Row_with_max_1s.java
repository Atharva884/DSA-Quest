// User function Template for Java

class Solution {
    // Brute Approach
    // TC: O(N*M), SC: O(1)
    // public int rowWithMax1s(int arr[][]) {
    //     int n = arr.length;
    //     int m = arr[0].length;
        
    //     int max = 0;
    //     int idx = -1;
        
    //     for(int i=0; i<n; i++){
    //         int cntOnes = 0;
            
    //         for(int j=0; j<m; j++){
    //             if(arr[i][j] == 1){
    //                 cntOnes++;
    //             }
    //         }
            
    //         if(cntOnes > max){
    //             max = cntOnes;
    //             idx = i;
    //         }
    //     }
        
    //     return idx;
    // }
    
    // Concept - {Smallest index whole value > x}
    public int lowerBound(int[] arr, int x){
        int n = arr.length;
        
        int lo = 0;
        int hi = n-1;
        
        int ans = -1;
        
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
    
    // Optimal Approach
    // TC: O(N * log(M)), SC: O(1)
    public int rowWithMax1s(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;
        
        int max = Integer.MIN_VALUE;
        int idx = -1;
        
        for(int i=0; i<n; i++){
            int cntOnes = lowerBound(arr[i], 0);
            
            if(cntOnes != -1){
                int ans = (m - cntOnes) + 1;
                
                if(ans > max){
                    max = ans;
                    idx = i;
                }
            }
            
        }
        
        return idx;
    }
}
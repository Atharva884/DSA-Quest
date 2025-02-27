// User function Template for Java
class Solution {
    public static int countCows(int[] arr, int minDist){
        int n = arr.length;
        int cows = 1;  
        int lastPos = arr[0];  
        
        for(int i = 1; i < n; i++){
            if(arr[i] - lastPos >= minDist){  
                cows++;
                lastPos = arr[i]; 
            }
        }
        
        return cows;
    }
    
    // TC: O(log(max - min)) * N, SC: O(1)
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls); 
        
        int n = stalls.length;
        int lo = Integer.MAX_VALUE;
        
        for(int i=1; i<n; i++){
            lo = Math.min(lo, stalls[i] - stalls[i-1]);
        }
        
        int hi = stalls[n - 1] - stalls[0];
        int ans = 0;
        
        while (lo <= hi) {
            int m = lo + ((hi - lo) >> 1);
            
            int cnt = countCows(stalls, m);
            
            if (cnt >= k) {
                ans = m;
                lo = m + 1;
            } else {
                hi = m - 1;
            }
        }
        
        return ans;
    }
}
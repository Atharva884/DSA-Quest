// User function Template for Java

class Solution {
    // Brute Approach
    // TC: O(nlogm), SC: O(1)
    public int nthRoot(int n, int m) {
        int lo = 0;
        int hi = m;
        
        while(lo <= hi){
            int mid = lo + ((hi - lo) >> 1);
            
            int val = (int) Math.pow((mid+1), n);

            
            if(val == m){
                return mid+1; 
            }else if(val > m){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        
        return -1;
    }
}
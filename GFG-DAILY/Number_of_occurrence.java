class Solution {
    // Concept -> { Smallest index whose value >= x }
    int lowerBound(int[] arr, int n, int x){
        int lo = 0;
        int hi = n - 1;
        
        int ans = n;
        
        while(lo <= hi){
            int m = lo + ((hi - lo) >> 1);
            
            if(arr[m] >= x){
                ans = m;
                
                hi = m - 1;
            }else{
                lo = m + 1;
            }
        }
        
        return ans;
    }
    
    // Concept -> { Smallest index whose value > x }
    int upperBound(int[] arr, int n, int x){
        int lo = 0;
        int hi = n - 1;
        
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
    
    // TC: O(logN), SC: O(1)
    int countFreq(int[] arr, int target) {
        int n = arr.length;
        
        int first = lowerBound(arr, n, target);
        
        if(first == n || arr[first] != target){
            return 0;
        }
        
        int last = upperBound(arr, n, target);
        
        int freq = ((last - 1) - first);
        
        return freq + 1;
    }
}

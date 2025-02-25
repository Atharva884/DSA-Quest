class Solution {
    // TC: O(logN), SC: O(1)
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;

        if(n == 1) return arr[0];

        // First Index
        if(arr[0] != arr[1]) return arr[0];

        // Last Index
        if(arr[n-1] != arr[n-2]) return arr[n-1];        

        int lo = 2;
        int hi = n-3;

        while(lo <= hi){
            int m = lo + ( ( hi - lo ) >> 1);

            if(arr[m] != arr[m-1] && arr[m] != arr[m+1]){
                return arr[m];
            }

            if(arr[m] == arr[m-1]){
                m--;
            }
            
            if((m & 1) == 0){
                lo = m + 2;
            }else{
                hi = m - 1;
            }
        }
        
        return -1;
    }
}
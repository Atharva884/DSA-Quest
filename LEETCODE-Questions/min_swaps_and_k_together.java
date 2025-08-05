class Solution {
    // Optimal Approach
    // TC: O(2N), SC: O(1)
    int minSwap(int[] arr, int b) {
        int n = arr.length;
        
        int window = 0;
        for(int num: arr){
            if(num <= b) window++;
        }
        
        int count = 0;
        int ans = Integer.MAX_VALUE;
        
        for(int i=0; i<window; i++){
            if(arr[i] <= b) count++;
        }

        ans = Math.min(ans, window - count);
        
        int sp = 0;
        int ep = window;

        while(ep < n){
            if(arr[ep] <= b) count++;
            if(arr[sp] <= b) count--;

            ans = Math.min(ans, window - count);
            
            sp++;
            ep++;
        }
        
        return ans;
    }
}

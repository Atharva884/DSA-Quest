class Solution {
    public int optimal(int[] arr, int k){
        int n = arr.length;
        
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<k; i++){
            sum += arr[i];
        }
        
        max = Math.max(max, sum);
        
        int sp = 0;
        int ep = k;

        while(ep < n){
            sum += arr[ep];
            sum -= arr[sp];
            
            max = Math.max(sum, max);
            
            sp++;
            ep++;
        }
        
        return max;
    }

    public int brute(int[] arr, int k){
        int n = arr.length;
        
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j < i + k && j < n; j++){
                sum += arr[j];
            }
            
            max = Math.max(max, sum);
        }
        
        return max;
    }
    
    public int maximumSumSubarray(int[] arr, int k) {
        // Brute Approach - TLE
        // TC: O(N * k), SC: O(1)
        // return brute(arr, k);
        
        // Optimal Approach
        // TC: O(N), SC: O(1)
        return optimal(arr, k);
    }
}

class Solution {
    // Optimal Approach
    // TC: O(N), SC: O(1)
    public int maxSubArray(int[] arr) {
        int n = arr.length;
        
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i=0; i<n; i++){
            if(sum >= 0){
                sum += arr[i];
            }else{
                sum = arr[i];
            }
            
            ans = Math.max(ans, sum);
        }
        
        return ans;
    }
}

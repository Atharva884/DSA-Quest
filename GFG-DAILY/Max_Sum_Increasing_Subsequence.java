// User function Template for Java

class Solution {
    public int maxSumIS(int arr[]) {
        int n = arr.length;
        
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            dp[i] = arr[i];
        }
        
        int max = dp[0];
        for(int i=1; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(arr[j] < arr[i]){
                    int sum = dp[j] + arr[i];
                    
                    dp[i] = Math.max(sum, dp[i]);
                }
            }
            
            max = Math.max(dp[i], max);
        }
        
        
        
        return max;
    }
}
// User function Template for Java

class Solution {
    // Brute Approach 
    // Use the two loops, and generate all the subarrays and take the longest
    // length subarray whose sum is equal to k
    // TC: O(N^2), SC: O(1)
    
    public int[] prefixSum(int[] arr, int n){
        int[] pfSum = new int[n];
        pfSum[0] = arr[0];
        
        for(int i=1; i<n; i++){
            pfSum[i] = pfSum[i-1] + arr[i];
        }
        
        return pfSum;
    }
    
    // Optimal Approach
    // TC: O(N), SC: O(N)
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> idxMap = new HashMap<>();
        int[] pfSum = prefixSum(arr, n);
        

        int ans = 0;
        
        map.put(0, 1);
        idxMap.put(0, -1);
        
        int ep = 0;
        while(ep < n){
            int diff = pfSum[ep] - k;
            
            if(map.containsKey(diff)){
                int len = ep - idxMap.get(diff);
                ans = Math.max(ans, len);
            }
            
            map.put(pfSum[ep], map.getOrDefault(pfSum[ep], 0) + 1);
            
            // We just need to store the first occurence bcz we are finding
            // longest subarray.
            if (!idxMap.containsKey(pfSum[ep])) {
                idxMap.put(pfSum[ep], ep);
            }
            
            ep++;
        }
        
        
        return ans;
    }
}

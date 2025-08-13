// User function Template for Java

class Solution {
    // Brute Approach 
    // Use the two loops, and generate all the subarrays and take the longest
    // length subarray whose sum is equal to k
    // TC: O(N^2), SC: O(1)
    
    // Optimal Approach
    // TC: O(N), SC: O(N)
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int ep = 0;
        int pfSum = 0;
        int maxLen = 0;
        
        while(ep < n){
           pfSum += arr[ep];
           
           int diff = pfSum - k;
           
           if(map.containsKey(diff)){
               maxLen = Math.max(maxLen, ep - map.get(diff));
           }
           
           if(!map.containsKey(pfSum)){
               map.put(pfSum, ep);
           }
           
           ep++;
        }
        
        return maxLen;
    }
}

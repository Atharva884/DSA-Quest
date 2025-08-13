// User function Template for Java

class Solution {
    // Optimal Approach
    // TC: O(N), SC: O(1)
    public static int smallestSubWithSum(int x, int[] arr) {
        int n = arr.length;
        
        int sp = 0;
        int ep = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        
        while(ep < n){
            sum += arr[ep];
            
            while(sum > x){
                sum -= arr[sp];
                minLen = Math.min(minLen, ep - sp + 1);
                sp++;
            }
            
            ep++;
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}

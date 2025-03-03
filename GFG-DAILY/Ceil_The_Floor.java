// User function Template for Java

class Solution {
    // TC: O(N), SC: O(1)
    public int[] getFloorAndCeil(int x, int[] arr) {
        int n = arr.length;
        int floor = Integer.MIN_VALUE;
        int ceil = Integer.MAX_VALUE;
        
        for(int i=0; i<n; i++){
            if(arr[i] == x){
                floor = x;
                ceil = x;
                break;
            }
            
            if(arr[i] < x){
                floor = Math.max(floor, arr[i]);
            }
            
            if(arr[i] > x){
                ceil = Math.min(ceil, arr[i]);
            }
        }
        
        return new int[]{floor == Integer.MIN_VALUE ? -1 : floor, ceil == Integer.MAX_VALUE ? -1 : ceil};
    }
}

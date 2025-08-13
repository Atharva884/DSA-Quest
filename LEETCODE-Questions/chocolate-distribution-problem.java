// User function Template for Java
import java.util.*;

class Solution {
    // TC: O(NlogN), SC: O(1)
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        Collections.sort(arr);
        int n = arr.size();
        
        int sp = 0;
        int ep = m-1;
        
        int diff = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        while(ep < n){
            diff = Math.min(diff, arr.get(ep) - arr.get(sp));
            
            sp++;
            ep++;
        }
        
        return diff;
    }
}

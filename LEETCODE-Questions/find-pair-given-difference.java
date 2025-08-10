
class Solution {
    // TC: O(N), SC: O(N)
    public boolean findPair(int[] arr, int x) {
        int n = arr.length;
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i=0; i<n; i++){
            if(hs.contains(arr[i] - x) || hs.contains(arr[i] + x)){
                return true;
            }
            hs.add(arr[i]);
        }
        
        return false;
    }
}

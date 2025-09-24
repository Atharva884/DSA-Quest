class Solution {
    // Optimal Approach
    // TC: O(N), SC: O(1)
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;

        int max = Integer.MIN_VALUE;
        int count = 0;

        for(int i=0; i<n; i++){
            max = Math.max(max, arr[i]);

            if(max == i) count++;
        }

        return count;
    }
}

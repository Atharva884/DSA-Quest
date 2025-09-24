class Solution {
    public int[] prefixMax(int[] arr, int n){
        int[] pfMax = new int[n];
        pfMax[0] = arr[0];

        for(int i=1; i<n; i++){
            pfMax[i] = Math.max(pfMax[i-1], arr[i]);
        }

        return pfMax;
    }

    public int[] suffixMin(int[] arr, int n){
        int[] sfMin = new int[n];
        sfMin[n-1] = arr[n-1];

        for(int i=n-2; i>=0; i--){
            sfMin[i] = Math.min(arr[i], sfMin[i+1]);
        }
        
        return sfMin;
    }

    // Optimal Approach
    // TC: O(N) + O(N) + O(N) ~ O(N), SC: O(N)
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;

        int[] pfMax = prefixMax(arr, n);
        int[] sfMin = suffixMin(arr, n);

        int count = 0;
        for(int i=0; i<n-1; i++){
            if(pfMax[i] <= sfMin[i+1]) count++;
        }

        count++;

        return count;
    }
}

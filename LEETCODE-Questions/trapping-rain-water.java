class Solution {
    public int[] prefixMax(int[] arr, int n){
        int[] pfMax = new int[n];
        pfMax[0] = arr[0];

        for(int i=1; i<n; i++){
            pfMax[i] = Math.max(pfMax[i-1], arr[i]);
        }

        return pfMax;
    }
    
    public int[] suffixMax(int[] arr, int n){
        int[] sfMax = new int[n];
        sfMax[n-1] = arr[n-1];

        for(int i=n-2; i>=0; i--){
            sfMax[i] = Math.max(sfMax[i+1], arr[i]);
        }

        return sfMax;
    }
    

    public int optimal(int[] height, int n){
        int[] pfMax = prefixMax(height, n);
        int[] sfMax = suffixMax(height, n);

        int sum = 0;
        for(int i=1; i<n-1; i++){
            int lb = pfMax[i-1];
            int rb = sfMax[i+1];
            int contri = Math.min(lb, rb) - height[i];

            if(contri >= 0) sum += contri;
        }

        return sum;
    }

    public int trap(int[] height) {
        int n = height.length;

        // Brute Approach
        // For each index, run the loop from (0, i-1) and find the left max blockade and also
        // loop from (i+1, n-1) and find the right max blockade and then compute how much water
        // can be stored at index i.
        // TC: O(N^2), SC: O(1)

        // Optimal Approach
        // TC: O(N+N+N) ~ O(N), SC: O(N)
        return optimal(height, n);
    }
}

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

    // TC: O(N), SC: O(N)
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;

        int[] pfMax = prefixMax(height, n);
        int[] sfMax = suffixMax(height, n);

        for(int i=1; i<n-1; i++){
            int lb = pfMax[i-1];
            int rb = sfMax[i+1];
            int yb = Math.min(lb, rb) - height[i];

            if(yb >= 1) ans += yb;
        }

        return ans;
    }
}

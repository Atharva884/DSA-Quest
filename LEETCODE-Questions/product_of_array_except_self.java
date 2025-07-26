class Solution {
    public int[] prefixProduct(int[] arr, int n){
        int[] pfProduct = new int[n];

        pfProduct[0] = arr[0];
        for(int i=1; i<n; i++){
            pfProduct[i] = pfProduct[i-1] * arr[i]; 
        }

        return pfProduct;
    }

    public int[] suffixProduct(int[] arr, int n){
        int[] sfProduct = new int[n];

        sfProduct[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--){
            sfProduct[i] = sfProduct[i+1] * arr[i]; 
        }

        return sfProduct;
    }

    // TC: O(3N), SC: O(2N)    
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int[] pfProduct = prefixProduct(nums, n);
        int[] sfProduct = suffixProduct(nums, n);

        ans[0] = sfProduct[1];
        ans[n-1] = pfProduct[n-2];

        for(int i=1; i<n-1; i++){
            int val = pfProduct[i-1] * sfProduct[i+1];
            ans[i] = val;
        }

        return ans;
    }
}

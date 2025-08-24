class Solution {
    public void brute(int[] nums, int k){
        int n = nums.length;
        int[] ans = new int[n];

        int shift = k;
        if(k > n){
            shift = k % n;
        }

        int idx = 0;
        for(int i=n-shift; i<n; i++){
            ans[idx++] = nums[i];
        }

        for(int i=0; i<n-shift; i++){
            ans[idx++] = nums[i];
        }

        for(int i=0; i<n; i++){
            nums[i] = ans[i];
        }
    }
    
    public void rotate(int[] nums, int k) {
        // Brute Approach
        // TC: O(N), SC: O(N)
        return brute(nums, k);
    }
}

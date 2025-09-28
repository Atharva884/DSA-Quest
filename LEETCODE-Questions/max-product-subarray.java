class Solution {
    // Optimal Approach
    // TC: O(N), SC: O(1)
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int pfSum = 1;
        int sfSum = 1;

        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(pfSum == 0) pfSum = 1;
            if(sfSum == 0) sfSum = 1;

            pfSum *= nums[i];
            sfSum *= nums[n-1-i];

            max = Math.max(max, Math.max(pfSum, sfSum));
        }

        return max;
    }
}

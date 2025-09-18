class Solution {
    public int[] brute(int[] nums, int n){
        int[] ans = new int[n];

        for(int i=0; i<n; i++){
            int sum = nums[i];
            for(int j=0; j<i; j++){
                sum += nums[j];
            }
            ans[i] = sum;
        }

        return ans;
    }

    public int[] optimal(int[] nums, int n){
        int[] prefix = new int[n];

        prefix[0] = nums[0];

        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }

        return prefix;
    }

    public int[] runningSum(int[] nums) {
        int n = nums.length;

        // Brute Approach
        // TC: O(N^2), SC: O(1) 
        // return brute(nums, n);

        // Optimal Approach
        // TC: O(N), SC: O(1)
        return optimal(nums, n);
    }
}

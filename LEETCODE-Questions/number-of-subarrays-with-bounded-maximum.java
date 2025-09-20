class Solution {
    public int brute(int[] nums, int n, int left, int right){
        int count = 0;

        for(int sp=0; sp<n; sp++){
            for(int ep=sp; ep<n; ep++){
                int max = -1;
                for(int i=sp; i<=ep; i++){
                    max = Math.max(max, nums[i]);
                }
                if(max >= left && max <= right) count++;
            }
        }

        return count;
    }

    public int optimal(int[] nums, int n, int left, int right){
        int ans = 0;
        int prevValidAns = 0;
        int lgei = 0;

        for(int ep=0; ep<n; ep++){

            if(nums[ep] > right){
                lgei = ep+1;
                prevValidAns = 0;
            }else if(nums[ep] >= left && nums[ep] <= right){
                ans += ep - lgei + 1;
                prevValidAns = ep - lgei + 1;
            }else{
                ans += prevValidAns;
            }
        }

        return ans;
    }  

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;

        // Brute Approach - TLE
        // TC: O(N^3), SC: O(1)
        // return brute(nums, n, left, right);

        // Optimal Approach
        // TC: O(N), SC: O(1)
        return optimal(nums, n, left, right);
    }
}

class Solution {
    // TC: O(logN), SC: O(1)
    public int findMin(int[] nums) {
        int n = nums.length;

        int lo = 0;
        int hi = n-1;
        int ans = Integer.MAX_VALUE;

        while(lo <= hi){
            int m = lo + ((hi - lo) >> 1);

            if(nums[lo] == nums[m] && nums[m] == nums[hi]){
                // It can be our answer
                ans = Math.min(ans, nums[lo]);

                lo++;
                hi--;
                continue;
            }

            if(nums[lo] <= nums[m]){
                ans = Math.min(ans, nums[lo]);
                lo = m + 1;
            }else{
                ans = Math.min(ans, nums[m]);
                hi = m - 1;
            }
        }

        return ans;
    }
}
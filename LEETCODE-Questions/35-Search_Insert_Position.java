class Solution {
    // TC: O(logN), SC: O(1)
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;

        int lo = 0;
        int hi = n-1;
        int ans = -1;

        while(lo <= hi){
            int m = lo + ((hi - lo) >> 1);

            if(nums[m] == target){
                return m;
            }else if(nums[m] > target){
                hi = m - 1;
            }else{
                ans = m;
                lo = m + 1;
            }
        }

        return ans + 1;
    }
}
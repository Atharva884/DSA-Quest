class Solution {
    // TC: O(logN), SC: O(1)
    public boolean search(int[] nums, int target) {
        int n = nums.length;

        int lo = 0;
        int hi = n-1;

        while(lo <= hi){
            int m = lo + ((hi - lo) >> 1);

            if(nums[m] == target) return true;

            if(nums[lo] == nums[m] && nums[m] == nums[hi]){
                lo++;
                hi--;
                continue;
            }

            // Left Sorted
            if(nums[lo] <= nums[m]){
                if(target >= nums[lo] && target <= nums[m]){
                    hi = m - 1;
                }else{
                    lo = m + 1;
                }
            }else{
                if(target >= nums[m] && target <= nums[hi]){
                    lo = m + 1;
                }else{
                    hi = m - 1;
                }
            }
        }

        return false;
    }
}
class Solution {
    // TC: O(logN), SC: O(1)
    public int search(int[] nums, int target) {
        int n = nums.length;

        int lo = 0;
        int hi = n-1;

        while(lo <= hi){
            int m = lo + ((hi - lo) >> 1);

            if(nums[m] == target) return m;

            if(nums[lo] <= nums[m]){
                if(target >= nums[lo] && target <= nums[m]){
                    hi = m-1;
                }else{
                    lo = m+1;
                }
            }else{
                if(target >= nums[m] && target <= nums[hi]){
                    lo = m+1;
                }else{
                    hi = m-1;
                }
            }
        }

        return -1;
    }
}
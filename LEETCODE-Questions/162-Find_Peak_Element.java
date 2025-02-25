class Solution {
    // TC: O(logN), SC: O(1)
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        // Edge Cases
        if(n == 1 || nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        int lo = 1;
        int hi = n-2;

        while(lo <= hi){
            int m = lo + ((hi - lo) >> 1);

            if(nums[m] > nums[m-1] && nums[m] > nums[m+1]){
                return m;
            }else if(nums[m-1] > nums[m]){
                hi = m - 1;
            }else{
                lo = m + 1;
            }
        }

        return -1;
    }
}
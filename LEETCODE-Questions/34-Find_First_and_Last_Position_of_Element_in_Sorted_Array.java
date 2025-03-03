class Solution {
    // Lower Bound - {smallest index whose value >= x}
    public static int lowerBound(int[] arr, int n, int x) {
        int lo = 0;
        int hi = n - 1;
        int ans = n;

        while(lo <= hi){
            int m = lo + ((hi - lo) >> 1);

            if(arr[m] >= x){
                ans = m;
                hi = m - 1;
            }else{
                lo = m + 1;
            }
        }

        return ans;
    }

    // Upper Bound - {smallest index whose value > x}
    public static int upperBound(int[] arr, int n, int x){
        int lo = 0;
        int hi = n - 1;
        int ans = n;

        while(lo <= hi){
            int m = lo + ((hi - lo) >> 1);

            if(arr[m] > x){
                ans = m;
                hi = m - 1;
            }else{
                lo = m + 1;
            }
        }

        return ans;
    }

    // TC: O(logN), SC: O(1)
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        int first = lowerBound(nums, n, target);

        if(first == n || nums[first] != target){
            return new int[]{-1, -1};
        }

        int last = upperBound(nums, n, target);

        return new int[]{first, last - 1};
    }
}
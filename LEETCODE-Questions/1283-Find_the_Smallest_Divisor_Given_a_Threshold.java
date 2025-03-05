class Solution {
    public static int max(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int val : arr) {
            max = Math.max(max, val);
        }

        return max;
    }

    public int calSum(int[] arr, int divisor){
        int sum = 0;

        for(int val: arr){
            sum += Math.ceil(val / (divisor * 1.0));
        }

        return sum;
    }

    // TC: O(log(max(nums))) * O(N), SC: O(1)
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;

        int lo = 1;
        int hi = max(nums);
        int ans = 0;

        while(lo <= hi){
            int m = lo + ((hi - lo) >> 1);

            int sum = calSum(nums, m);

            if(sum <= threshold){
                ans = m;
                hi = m - 1;
            }else{
                lo = m + 1;
            }
        }

        return ans;
    }
}
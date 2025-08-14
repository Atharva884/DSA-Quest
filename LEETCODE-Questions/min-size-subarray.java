class Solution {
    // Optimal Approach
    // O(N + N) ~ O(2N), SC: O(1)
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;

        int minLen = Integer.MAX_VALUE;
        int sp = 0;
        int ep = 0;
        int sum = 0;

        while(ep < n){
            sum += nums[ep];

            while(sum >= target){
                sum -= nums[sp];
                minLen = Math.min(minLen, ep - sp + 1);
                sp++;
            }

            ep++;
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}

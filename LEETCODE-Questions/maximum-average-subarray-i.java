class Solution {
    public double brute(int[] nums, int k){
        int n = nums.length;
        double ans = Integer.MIN_VALUE;

        for(int sp=0; sp<n; sp++){
            int sum = 0;
            for(int ep=sp; ep<n; ep++){
                sum += nums[ep];
                int len = ep - sp + 1;

                if(len == k){
                    ans = Math.max(ans, sum / (len * 1.0));
                }else if(len > k) break;
            }
        }

        return ans;
    }

    public double optimal(int[] nums, int k){
        int n = nums.length;

        int sp = 0;
        int sum = 0;
        double ans = Integer.MIN_VALUE;

        for(int i=0; i<k; i++){
            sum += nums[i];
        }

        ans = Math.max(ans, (sum / (k * 1.0)));

        int ep = k;

        while(ep < n){
            sum += nums[ep];
            sum -= nums[sp];

            ans = Math.max(ans, (sum / (k * 1.0)));

            sp++;
            ep++;
        }

        return ans;
    }

    public double findMaxAverage(int[] nums, int k) {
        // Brute Approach -- TLE 
        // TC: O(N^2), SC: O(1)
        // return brute(nums, k);

        // Optimal Approach
        // TC: O(N), SC: O(1)
        return optimal(nums, k);
    }
}

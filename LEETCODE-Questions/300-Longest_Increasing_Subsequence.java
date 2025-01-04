class Solution {
    // TC: O(N^2), SC: O(N)
    // public int lengthOfLIS(int[] nums) {
    //     int n = nums.length;

    //     int[] dp = new int[n];
    //     Arrays.fill(dp, 1);
    //     int ans = 1;

    //     for(int i=1; i<n; i++){
    //         for(int j=i-1; j>=0; j--){
    //             if(nums[j] < nums[i]){
    //                 dp[i] = Math.max(dp[i], dp[j] + 1);
    //             }
    //         }

    //         ans = Math.max(ans, dp[i]);
    //     }

    //     return ans;
    // }

    public int lengthOfLIS(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];

        int ans = 0;

        for(int i=0; i<n; i++){

            int lo = 0;
            int hi = ans;

            while(lo < hi){
                int m = lo + (hi-lo) / 2;

                if(nums[i] > dp[m]){
                    lo = m + 1;
                }else{
                    // Why not m-1?
                    // Bcoz, we need to find the ceil value
                    hi = m;
                }
            }

            dp[lo] = nums[i];
            if(lo == ans){
                ans++;
            }
        }

        return ans;
    }
}
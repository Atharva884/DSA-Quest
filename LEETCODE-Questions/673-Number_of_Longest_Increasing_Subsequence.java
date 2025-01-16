class Solution {
    // TC: O(N^2), SC: O(N)
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        int[] cnt = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);

        int maxLen = 1;

        for(int i=1; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(nums[j] < nums[i]){
                    int ans = dp[j] + 1;

                    // When the len changes
                    if(ans > dp[i]){
                        dp[i] = ans;
                        cnt[i] = cnt[j];
                    }else if(ans == dp[i]){
                        // Similar length but we have many LIS
                        cnt[i] += cnt[j];
                    }
                }
            }

            maxLen = Math.max(maxLen, dp[i]);
        }

        int count = 0;
        for(int i=0; i<n; i++){
            if(dp[i] == maxLen){
                count += cnt[i];
            }
        }

        return count;
    }
}
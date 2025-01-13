public class Solution {
    public static int[] subSetSumEqualsK(int[] arr, int n, int k){
        int[][] dp = new int[n][k + 1];

        for(int i=0; i<=k; i++){
            if(i == 0){
                dp[0][i] = 1;
                continue;
            }

            if(arr[0] == i) dp[0][i] = 1;
            else dp[0][i] = 0;
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<=k; j++){
                int notTake = dp[i-1][j];
                int take = 0;

                if(arr[i] <= j){
                    take = dp[i-1][j - arr[i]];
                }

                if(take == 1 || notTake == 1) dp[i][j] = 1;
                else dp[i][j] = 0;
            }
        }     

        return dp[n-1];   
    }   

    // Tabulation
    // TC: O(N*K) + O(K/2), SC: O(N*K)
    public static int minSubsetSumDifference(int []arr, int n) {
        int k = 0;
        for(int num: arr) k += num;

        int[] dp = subSetSumEqualsK(arr, n, k);

        int min = Integer.MAX_VALUE;
        for(int i=0; i <= k/2; i++){
            if(dp[i] == 1){
                int s2 = k - i;
                int diff = Math.abs(i - s2);
                min = Math.min(min, diff);
            }
        }

        return min;
    }
}

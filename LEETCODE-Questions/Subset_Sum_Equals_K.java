import java.util.* ;
import java.io.*; 

public class Solution {
    // public static boolean subSetSumEqualsK(int[] arr, int n, int i, int sum, int k, int[][] dp){
    //     if(i < 0){
    //         if(sum == k){
    //             return true;  // 1
    //         }
    //         return false; // 0
    //     }

    //     if(dp[i][sum] != -1){
    //         return dp[i][sum] == 1 ? true : false;
    //     } 

    //     boolean x = false;
    //     if(sum + arr[i] <= k){
    //         x = subSetSumEqualsK(arr, n, i-1, arr[i] + sum, k, dp);
    //     }
    //     boolean y = subSetSumEqualsK(arr, n, i-1, sum, k, dp);

    //     dp[i][sum] = (x || y) ? 1 : 0;

    //     return (x || y);
    // }

    // Recursion + Memoization
    // TC: O(N*K), SC: O(N*K) with stack space: O(N+K)

    // public static boolean subsetSumToK(int n, int k, int arr[]){
        // int[][] dp = new int[n][k+1];
        // for(int[] a: dp){
        //     Arrays.fill(a, -1);
        // }

    //     return subSetSumEqualsK(arr, n, n-1, 0, k, dp);
    // }


    // public static boolean solve(int i, int[] arr, int k, int[][] dp){
    //     if(k == 0) return true;

    //     if(i == 0){
    //         if(arr[0] == k) return true;

    //         return false;
    //     }

    //     if(dp[i][k] != -1) return dp[i][k] == 1 ? true : false;

    //     boolean notTake = solve(i-1, arr, k, dp);
    //     boolean take = false;

    //     if(arr[i] <= k){
    //         take = solve(i-1, arr, k - arr[i], dp);
    //     }

    //     dp[i][k] = (take || notTake) ? 1 : 0;

    //     return (take || notTake);
    // }

    // Recursion + Memoization
    // TC: O(N*K), SC: O(N*K) with stack space: O(N+K)

    // public static boolean subsetSumToK(int n, int k, int arr[]){
    //     int[][] dp = new int[n][k+1];
    //     for(int[] a: dp){
    //         Arrays.fill(a, -1);
    //     }

    //     return solve(n-1, arr, k, dp);
    // }


    // Tabulation
    // TC: O(N*K), SC: O(N*K)

    public static boolean subsetSumToK(int n, int k, int arr[]){
        int[][] dp = new int[n][k + 1];

        // Base case
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

        return dp[n-1][k] == 1 ? true : false;
    }
}

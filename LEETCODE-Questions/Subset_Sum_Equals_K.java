import java.util.* ;
import java.io.*; 

public class Solution {
    public static boolean subSetSumEqualsK(int[] arr, int n, int i, int sum, int k, int[][] dp){
        if(i >= n){
            if(sum == k){
                return true;
            }
            return false;
        }

        if(dp[i][sum] != -1){
            return dp[i][sum] == 1 ? true : false;
        } 

        boolean x = false;
        if(sum + arr[i] <= k){
            x = subSetSumEqualsK(arr, n, i+1, arr[i] + sum, k, dp);
        }
        boolean y = subSetSumEqualsK(arr, n, i+1, sum, k, dp);

        dp[i][sum] = (x || y) ? 1 : 0;

        return (x || y);
    }

    public static boolean subsetSumToK(int n, int k, int arr[]){
        int[][] dp = new int[n][k+1];
        for(int[] a: dp){
            Arrays.fill(a, -1);
        }

        return subSetSumEqualsK(arr, n, 0, 0, k, dp);
    }
}

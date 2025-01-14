import java.util.*;

public class Solution {
    // public static int solve(int i, int ex, int[][] arr, int n, int[][] dp){
    //     // if(i < 0) return 0;

    //     if(i == 0){
    //         int max = 0;
    //         for(int j=0; j<3; j++){
    //             if(j == ex) continue;
    //             max = Math.max(max, arr[0][j]);
    //         }

    //         return dp[i][ex] = max;
    //     }

    //     if(dp[i][ex] != -1) return dp[i][ex];


    //     int maxPoints = 0;
    //     for(int j=0; j<3; j++){
    //         if(j == ex) continue;

    //         int temp = arr[i][j] + solve(i-1, j, arr, n, dp);
    //         maxPoints = Math.max(maxPoints, temp);
    //     }

    //     return dp[i][ex] = maxPoints;
    // }
    
    // Recursion + Memoization
    // TC: O(N*4) * 3, SC: O(N*4) with stack space: O(N)

    // public static int ninjaTraining(int n, int points[][]) {
    //     int[][] dp = new int[n][4];
    //     for(int[] arr: dp){
    //         Arrays.fill(arr, -1);
    //     }

    //     // Why we are putting exc is 3 means no activity is performed
    //     return solve(n-1, 3, points, n, dp);
    // }

    // Tabulation
    // TC: O(N*4*3), SC: O(N*4)

    // public static int ninjaTraining(int n, int points[][]) {
    //     int[][] dp = new int[n][4];

    //     // Base cases
    //     dp[0][0] = Math.max(points[0][1], points[0][2]);
    //     dp[0][1] = Math.max(points[0][0], points[0][2]);
    //     dp[0][2] = Math.max(points[0][0], points[0][1]);
    //     dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
    
    //     for(int i=1; i<n; i++){
    //         for(int ex=0; ex<=3; ex++){
    //             int maxPoints = 0;
    //             for(int j=0; j<3; j++){
    //                 if(j == ex) continue;

    //                 int temp = points[i][j] + dp[i-1][j];
    //                 maxPoints = Math.max(maxPoints, temp);
    //             }

    //             dp[i][ex] = maxPoints;
    //         }
    //     }

    //     return dp[n-1][3];
    // }


    // Space Optimized
    // TC: O(N*4*3), SC: O(4)
    
    public static int ninjaTraining(int n, int points[][]) {

        int[] prev = new int[4];

        // Base case (using loop)
        for(int i=0; i<4; i++){
            if(i == 3){
                prev[i] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
                continue;
            }

            int max = 0;
            for(int j=0; j<3; j++){
                if(j != i){
                    max = Math.max(max, points[0][j]);
                }
            }
            prev[i] = max;
        }

        // Base cases
        // dp[0][0] = Math.max(points[0][1], points[0][2]);
        // dp[0][1] = Math.max(points[0][0], points[0][2]);
        // dp[0][2] = Math.max(points[0][0], points[0][1]);
        // dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
    
        for(int i=1; i<n; i++){
            int[] tmp = new int[4];

            for(int ex=0; ex<=3; ex++){
                int maxPoints = 0;
                for(int j=0; j<3; j++){
                    if(j == ex) continue;

                    int temp = points[i][j] + prev[j];
                    maxPoints = Math.max(maxPoints, temp);
                }

                tmp[ex] = maxPoints;
            }

            prev = tmp;
        }

        return prev[3];
    }

}

import java.util.*;

public class Solution {

    // TC: O(2(N^2)), SC: O(N) 
    public static List<Integer> printingLongestIncreasingSubsequence(int[] arr, int n) {

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLen = 1;
        int idx = 1;

        for(int i=1; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            if(dp[i] > maxLen){
                maxLen = dp[i];
                idx = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(arr[idx]);

        // Backtrack 
        while(idx >= 0){
            int req = dp[idx] - 1;
            
            int j = idx - 1;
            while(j >= 0 && (dp[j] != req || arr[j] >= arr[idx])) j--;

            if(j >= 0){
                ans.add(arr[j]);
                idx = j;
            }else{
                break;
            }
        }

        Collections.reverse(ans);

        return ans;
    }
}

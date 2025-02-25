import java.io.*;
import java.util.*;

public class Solution {

    // TC: O(logN), SC: O(1)
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();

        int lo = 0;
        int hi = n-1;
        int ans = 0;
        
        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(arr[mid] > k){
                hi = mid - 1;
            }else if(arr[mid] < k){
                ans = arr[mid];
                lo = mid + 1;
            }else{
                System.out.println(arr[mid]);
                return;
            }
        }
        
        System.out.println(ans);
    }
}

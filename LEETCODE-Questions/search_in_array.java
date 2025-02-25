import java.io.*;
import java.util.*;

public class Solution {

    // TC: O(logn), SC: O(1)
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        
        int k = scn.nextInt();

        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(arr[mid] > k){
                high = mid - 1;
            }else if(arr[mid] < k){
                low = mid + 1;
            }else{
                System.out.println("true");
                return;
            }
        }
        
        System.out.println("false");
    }
}

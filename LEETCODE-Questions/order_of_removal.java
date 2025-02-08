import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int sum = 0;
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
            sum += arr[i];
        }
        
        Arrays.sort(arr);

        int cost = 0;
        for(int i=n-1; i>=0; i--){
            cost += sum;
            sum -= arr[i];
        }
        
        System.out.println(cost);
    }
}

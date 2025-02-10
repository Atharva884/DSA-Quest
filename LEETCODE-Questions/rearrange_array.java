import java.io.*;
import java.util.*;

public class Solution {
    
    public static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // TC: O(N), SC: O(1)
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = scn.nextInt();
        }

        int p1 = 1;
        int p2 = N-1;
        int k = arr[0];
        
        while(p1 <= p2){
            if(arr[p1] <= k){
                p1++;
            }else if(arr[p2] > k){
                p2--;
            }else{
                swap(p1, p2, arr);
                p1++;
                p2--;
            }
        }

        swap(0, p2, arr);
        
        for(int i=0; i<N; i++){
            System.out.print(arr[i] + " ");
        }
    }
}

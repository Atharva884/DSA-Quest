import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        
        Arrays.sort(arr);
        
        int cnt = 0;

        if(arr[0] == 0) cnt++;

        int lessCnt = 0;
        
        for(int i=1; i<n; i++){
            if(arr[i] != arr[i-1]){
                lessCnt = i;
            }
            
            if(arr[i] == lessCnt) cnt++;
        }
        
        System.out.println(cnt);
    }
}

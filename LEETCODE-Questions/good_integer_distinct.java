import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = scn.nextInt();
        }

        Arrays.sort(arr);

        int cnt = 0;
        for(int i=0; i<N; i++){
            if(i == arr[i]){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

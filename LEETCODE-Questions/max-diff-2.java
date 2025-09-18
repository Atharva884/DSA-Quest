import java.io.*;
import java.util.*;


public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int num = scn.nextInt();
            min = Math.min(min, num+i);
            max = Math.max(max, num+i);
        }
        
        System.out.println(max - min);
    }
}

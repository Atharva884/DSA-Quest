import java.io.*;
import java.util.*;

public class Solution {
    // TC: O(N), SC: O(1)
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            max = Math.max(max, scn.nextInt());
        }
        
        System.out.println(max);
    }
}

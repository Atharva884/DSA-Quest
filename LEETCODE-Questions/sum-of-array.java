import java.io.*;
import java.util.*;

public class Solution {

    // TC: O(N), SC: O(1)
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += scn.nextInt();
        }

        System.out.println(sum);
    }
}

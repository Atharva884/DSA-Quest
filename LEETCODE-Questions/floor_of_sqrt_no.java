import java.io.*;
import java.util.*;

public class Solution {

    // Optimal Approach
    // TC: O(root N), SC: O(1)
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int ans = 1;
        int i = 1;
        while(i <= n/i){
            ans = i;
            i++;
        }
        
        System.out.println(ans);
    }
}

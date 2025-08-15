import java.io.*;
import java.util.*;

public class Solution {

    // Optimal Approach
    // TC: O(N), SC: O(1)
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        for(int i=1; i<=n; i+=2){
            System.out.println(i + " " + (i+1));
        }
    }
}

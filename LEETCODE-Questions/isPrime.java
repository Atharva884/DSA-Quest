import java.io.*;
import java.util.*;

public class Solution {

    public static void brute(int n){
        int count = 0;

        for(int i=1; i<=n; i++){
            if(n % i == 0) count++;
        }
        
        if(count == 2) System.out.println("Yay");
        else System.out.println("Nay");
    }

    public static int optimal(int n){
        int count = 0;

        for(int i=1; i<=n/i; i++){
            if(n % i == 0){
                if(i == n/i) count++;
                count+=2;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
    
        // Brute Approach
        // TC: O(N), SC: O(1)
        // brute(n);

        // Optimal Approach
        // TC: O(root N), SC: O(1)
        int ans = optimal(n); 
        if(ans == 2) System.out.println("Yay");
        else System.out.println("Nay");
    }
}

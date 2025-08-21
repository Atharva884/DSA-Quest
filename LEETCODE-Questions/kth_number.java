import java.io.*;
import java.util.*;

public class Solution {

    // TC: O(KlogK), SC: O(klogk)
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();

        Queue<String> q = new LinkedList<>();
        q.add("1");
        q.add("2");

        int idx = 1;
        while(!q.isEmpty()){
            String rem = q.poll();
            
            if(idx == k){
                System.out.println(rem);
                break;
            }
            
            q.add(rem + "1");
            q.add(rem + "2");
            idx++;
        }
        
        System.out.println("");
    }
}

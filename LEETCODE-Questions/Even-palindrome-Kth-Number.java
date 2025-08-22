import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();

        Queue<String> q = new LinkedList<>();
        q.add("11");
        q.add("22");
        
        String ans = "";
        for(int i=1; i<=k; i++){
            String rem = q.poll();
            ans = rem;
            String l = rem.substring(0, rem.length() / 2);
            String r = rem.substring(rem.length() / 2, rem.length());
            q.add(l + "11" + r);
            q.add(l + "22"  + r);
        }
        
        System.out.println(ans);
    }
}

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            // int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().Maximize(arr));
        }
        out.close();
    }
}
// } Driver Code Ends
// User function Template for Java

class Solution {
    static int MOD = (int) 1e9 + 7;
    
    // Brute Force Approach
    // TC: O(NlogN), SC: O(N)
    
    // int Maximize(int[] arr){
    //     PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    //     int n = arr.length;
        
    //     for(int i=0; i<n; i++){
    //         pq.add(arr[i]);
    //     }
        
    //     int len = arr.length - 1;
        
    //     long sum = 0;
    //     while(!pq.isEmpty()){
    //         int rem = pq.poll();
            
    //         if(len >= 0){
    //             sum = (sum + (long) rem * len) % MOD;
    //         }
            
    //         len--;
    //     }
        
    //     return (int) sum;
    // }
    
    // Optimal Approach
    // TC: O(nlogn), SC: O(1)
    
    int Maximize(int arr[]) {
        int n = arr.length;
        
        Arrays.sort(arr);
        
        long sum = 0;
        for(int i=0; i<n; i++){
            sum = (sum + (long) arr[i] * i) % MOD;
        }
        
        return (int) sum;
    }
    
    
    
}

//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) end[i] = Integer.parseInt(inputLine[i]);

            int ans = new Solution().maxMeetings(n, start, end);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    
    // TC: O(N*logN), SC: O(n)
    public static int maxMeetings(int n, int[] start, int[] end) {
        int[][] m = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            m[i][0] = start[i];
            m[i][1] = end[i];
        }

        // Sort the meeting in ascending order based on end time
        Arrays.sort(m, (a, b) -> a[1] - b[1]);
        
        int count = 0;
        int lastMeet = -1;
        
        // Looping from 1 to n
        for(int i=0; i<n; i++){
            int startTime = m[i][0];
            int endTime = m[i][1];
            
            if(startTime > lastMeet){
                count++;
                lastMeet = endTime;
            }
        }
        
        return count;
    }
}

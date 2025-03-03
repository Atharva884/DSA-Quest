class Solution {

    // TC: O(logN), SC: O(1) 
    static int findFloor(int[] arr, int k) {
        int n = arr.length;
        
        int lo = 0;
        int hi = n-1;
        int ans = -1;
        
        while(lo <= hi){
            int m = lo + ((hi - lo) >> 1);
            
            if(arr[m] == k){
                return m;
            }else if(arr[m] > k){
                hi = m - 1;
            }else{
                ans = m;
                lo = m + 1;
            }
        }
        
        return ans;
    }
}



//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
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

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.findFloor(arr, k);

            System.out.print(ans);

            System.out.println(); // New line after printing the results
        }
    }
}


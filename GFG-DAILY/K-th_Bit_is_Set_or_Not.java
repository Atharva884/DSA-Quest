// User function Template for Java

class CheckBit {
    // TC: O(1), SC: O(1)
    static boolean checkKthBit(int n, int k) {
        if((n & (1 << k)) != 0) return true;
        
        return false;
    }
}

//{ Driver Code Starts.

class GFG {
    static int n;
    static int k;

    // Driver Code
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); // Inputting the testcases

        while (t > 0) // While testcases exist
        {

            n = Integer.parseInt(br.readLine()); // Input N
            k = Integer.parseInt(br.readLine()); // Input K

            CheckBit obj = new CheckBit();

            if (obj.checkKthBit(n, k))
                System.out.println("true"); // If true, print Yes

            else
                System.out.println("false"); // Else print No

            t--;

            System.out.println("~");
        }
    }
}

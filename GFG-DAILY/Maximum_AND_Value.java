//User function Template for Java

class Solution{
    public static boolean checkBit(int N, int i){
        if((N & (1 << i)) != 0) return true;
        
        return false;
    }
    
    // TC: O(N), SC: O(1)
    public static int maxAND(int arr[], int N) {
        if(N == 1){
            return 0;
        }
        
        for(int i=31; i>=0; i--){
            
            int count = 0;
            
            for(int j=0; j<N; j++){
                if(checkBit(arr[j], i)){
                    count++;
                }
            }
            
            // We have atleast 2 pairs then, we can remove some numbers
            if(count >= 2){
                for(int j=0; j<N; j++){
                    if(!checkBit(arr[j], i)){
                        arr[j] = 0;
                    }
                }   
            }
        }
        
        int idx1 = -1;
        int idx2 = -1;
        
        for(int j=0; j<N; j++){
            if(arr[j] > 0){
                if(idx1 == -1){
                    idx1 = arr[j];
                }else if(idx1 != -1){
                    idx2 = arr[j];
                    break;
                }
            }
        }
        
        return idx1 & idx2;
    }
}

//{ Driver Code Starts.

class BitWise {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    
		    //input size of array
		    int n = Integer.parseInt(br.readLine());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int arr[] = new int[n];
		    
		    //inserting elements in the array
		    for(int i=0; i<n; i++){
		        arr[i]=Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling maxAND() method of class AND
		    System.out.println(obj.maxAND(arr, n));
		
System.out.println("~");
}
	}
}


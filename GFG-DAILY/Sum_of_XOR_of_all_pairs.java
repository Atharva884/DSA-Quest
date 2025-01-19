//User function Template for Java

class Solution{
    
    public boolean checkBit(int N, int i){
        if((N & (1 << i)) != 0) return true;
        return false;
    }
    
    // TC: O(32 * N) ~ O(N), SC: O(1)
    public long sumXOR(int arr[], int n) {
        
        long ans = 0;
        
        for(int i=31; i>=0; i--){
            
            long count = 0;
            for(int j=0; j<n; j++){
                if(!checkBit(arr[j], i)){
                    count++;
                }
            }
            
            long ones = n - count;
            long temp = (ones * count) * (1 << i);
            
            ans += temp;
        }
        
        return ans;
    }
    
    
}



// User function Template for Java
class Solution {
    public int[] sieveOfErastothenes(int n){
        int[] arr = new int[n+1];
        for(int i=0; i<=n; i++){
            arr[i] = i;
        }
        
        arr[0] = 0;
        arr[1] = 1;
        
        for(int i=2; i <= n / i; i++){
            if(arr[i] == i){
                for(int j=i*i; j <= n; j+=i){
                    if(arr[j] == j){
                        arr[j] = i;
                    }
                }
            }
        }
        
        return arr;
    }
    
    // Optimal Approach
    // TC: O(NloglogN + O(N+1)), SC: O(N)
    public int[] leastPrimeFactor(int n) {
        int[] sieve = sieveOfErastothenes(n);
        
        int[] ans = new int[n+1];
        for(int i=0; i<=n; i++){
            ans[i] = sieve[i];
        }
        
        return ans;
    }
}

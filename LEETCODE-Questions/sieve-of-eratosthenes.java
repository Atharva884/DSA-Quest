class Solution {
    // TC: O(root N), SC: O(1)
    public int countOfFactors(int n){
        int count = 0;
        
        for(int i=1; i<=n/i; i++){
            if(n % i == 0){
                if(i == n/i) count++;
                count += 2;
            }
        }
        
        return count;
    }
    
    public boolean isPrime(int n){
        int factors = countOfFactors(n);
        
        if(factors == 2) return true;
        return false;
    }
    
    public int[] brute(int n){
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=2; i<=n; i++){
            if(isPrime(i)){
                arr.add(i);
            }
        }
        
        int[] res = new int[arr.size()];
        int idx = 0;
        for(int num: arr){
            res[idx++] = num;
        }
        
        return res;
    }
    
    
    public int[] optimal(int n){
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr, true);
        
        int len = arr.length;
        int count = 0;
        
        arr[0] = arr[1] = false;
        
        for(int i=2; i <= n / i; i++){
            if(arr[i]){
                for(int j=i*i; j <= n; j+=i){
                    arr[j] = false;
                }
            }
        }
        
        for(int i=2; i<=n; i++){
            if(arr[i]){
                count++;
             }
        }
       
       int[] primes = new int[count];
       int idx = 0;
       for(int i=2; i<=n; i++){
           if(arr[i]){
               primes[idx++] = i;
           }
       }
        
       return primes;
    }
    
    public int[] sieve(int n) {
        // Brute Approach
        // TC: O(N * root N), SC: O(N)
        // return brute(n);
        
        // Optimal Approach
        // TC: O(N*loglogN), SC: O(N)
        return optimal(n);
    }
}

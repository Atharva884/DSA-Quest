class Solution {
    static int countFactors(int n){
        int count = 0;
        
        for(int i=1; i<=n; i++){
            if(n % i == 0) count++;
        }
        
        return count;
    }
    
    static boolean brute(int n){
        int factor = countFactors(n);
        
        return factor == 2 ? true : false;
    }
    
    static int optimalCountFactors(int n){
        int count = 0;
        
        for(int i=1; i<=n/i; i++){
            if(n % i == 0){
                if(i == n / i){
                    count++;
                    continue;
                }
                
                count += 2;
            }
        }
        
        return count;
    }
    
    static boolean optimal(int n){
        int factor = optimalCountFactors(n);
        
        return factor == 2 ? true : false;
    }
    
    static boolean isPrime(int n) {
        // Brute Approach - TLE
        // TC: O(N), SC: O(1)
        // return brute(n);
        
        // Optimal Approach
        // TC: O(sqrt(N)), SC: O(1)
        return optimal(n);
    }
}

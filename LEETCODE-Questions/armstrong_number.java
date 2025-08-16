// User function Template for Java
class Solution {
    // Optimal Approach
    // TC: O(log10 (n)), SC: O(1)
    static boolean armstrongNumber(int n) {
        int dup = n;
        
        int sum = 0;
        while(n != 0){
            int lastDigit = n % 10;
            
            sum += (lastDigit * lastDigit * lastDigit);
            
            n = n / 10;
        }
        
        return sum == dup ? true : false;
    }
}

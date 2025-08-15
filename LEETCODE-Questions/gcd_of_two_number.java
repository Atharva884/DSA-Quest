class Solution {
    
    public static int optimal(int a, int b){
        if(a == 0) return b;
        
        int temp = optimal(b % a, a);
        
        return temp;
    }
    
    public static int gcd(int a, int b) {
        // Optimal Approach
        // TC: O(logN) ~ where N is max(a, b), SC: O(logN)
        return optimal(a, b);
    }
}

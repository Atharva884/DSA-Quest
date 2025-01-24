class Solution {
    // Brute Force Approach
    // TC: O(32), SC: O(1)
    // public boolean isPowerOfTwo(int n) {
    //     if(n == 0) return false;
    //     if(n == Integer.MIN_VALUE) return false;

    //     int ans = 0;
    //     for(int i=31; i>=0; i--){
    //         if((n & (1 << i)) != 0){
    //             ans++;
    //         }
    //     }

    //     if(ans > 1) return false;

    //     return true;
    // }

    // Optimal Approach -> Efficient
    // TC: O(1), SC: O(1)

    // As we know, there will be only 1 set bit if its a power of 2
    // and if we remove the rightmost set bit it should be 0.
    public boolean isPowerOfTwo(int n) {
        if(n == Integer.MIN_VALUE) return false;
        if(n == 0) return false;

        if((n & (n-1)) == 0) return true;

        return false;
    }
}
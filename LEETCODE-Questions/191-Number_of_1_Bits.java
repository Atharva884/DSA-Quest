class Solution {
    // Not Efficent
    // TC: O(32), SC: O(1)
    // public int hammingWeight(int n) {
    //     int ans = 0;

    //     for(int i=31; i>=0; i--){
    //         if((n & (1 << i)) != 0){
    //             ans++;
    //         }
    //     }

    //     return ans;
    // }

    // Efficent (Using bit manipulation)
    // TC: O(1), SC: O(1)
    public int hammingWeight(int n){
        int cnt = 0;

        while(n > 0){
            cnt += (n & 1);      // It checks for even or odd

            n = n >> 1;          // Dividing by 2
        }

        return cnt;
    }
}
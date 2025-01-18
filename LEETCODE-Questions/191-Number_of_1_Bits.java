class Solution {
    // TC: O(N), SC: O(1)
    public int hammingWeight(int n) {
        int ans = 0;

        for(int i=31; i>=0; i--){
            if((n & (1 << i)) != 0){
                ans++;
            }
        }

        return ans;
    }
}
// User function Template for Java
class Solution {
    // TC: O(1), SC: O(1)
    static int setKthBit(int n, int k) {
        return (n | (1 << k));
    }
}
class Solution {
    // TC: O(N), SC: O(1)
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;

        for(int num: nums){
            xor = num ^ xor;
        }

        return xor;
    }
}
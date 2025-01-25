class Solution {
    // Brute Approach
    // TC: O(N), SC: O(N)

    // public int missingNumber(int[] nums) {
    //     int n = nums.length;

    //     int[] freq = new int[n+1];

    //     for(int num: nums){
    //         freq[num]++;
    //     }

    //     for(int i=0; i<n+1; i++){
    //         if(freq[i] == 0) return i;
    //     }

    //     return -1;
    // }

    // Optimal Approach
    // TC: O(N), SC: O(1)

    // Approach
    // As we know, there is only 1 element which is missing from the nums array and if 
    // we do xor with the range (0 -> n) & all the elements of the num, there will be only 
    // 1 element which will survive as it was missing no in the nums
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int xor = 0;

        for(int num: nums){
            xor ^= num;
        }

        for(int i=0; i<=n; i++){
            xor ^= i;
        }

        return xor;
    }
}
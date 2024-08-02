class Solution {
    // TC: O(N) + O(K) + O(N), SC: O(1) 
    public int minSwaps(int[] nums) {
        int n = nums.length;

        int windowSize = 0;
        for(int num: nums){
            windowSize += num;
        }

        int curZeroes = 0;
        for(int i=0; i<windowSize; i++){
            if(nums[i] == 0){
                curZeroes++;
            }
        }

        int minZeroes = curZeroes;
        int start = 0;
        int end = windowSize - 1;

        while(start < n){

            if(nums[start] == 0){
                curZeroes--;
            }
            start++;

            end++;
            if(nums[end % n] == 0){
                curZeroes++;
            }

            minZeroes = Math.min(minZeroes, curZeroes);
        }

        return minZeroes;
    }
}
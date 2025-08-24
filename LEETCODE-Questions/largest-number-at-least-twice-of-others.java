class Solution {
    // TC: O(N + N) ~ O(N), SC: O(1) 
    public int dominantIndex(int[] nums) {
        int n = nums.length;

        int max = 0;
        int idx = -1;
        for(int i=0; i<n; i++){
            if(nums[i] > max){
                max = nums[i];
                idx = i;
            }   
        }   

        for(int i=0; i<n; i++){
            if(nums[i] == max) continue;
            if(max < 2 * nums[i]) return -1;
        }        

        return idx;
    }
}

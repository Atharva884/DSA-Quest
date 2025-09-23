class Solution {
    public void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // TC: O(N) + O(N) ~ O(N), SC: O(1)
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;

        while(i < n){

            if(nums[i] < 1 || nums[i] > n || nums[i]-1 == i){
                i++;
            }else{
                int idx = nums[i]-1;
                // Case: When the nums[i] == nums[idx] means identical, then 
                // it will end up looping causing TLE, as we are only doing
                // swapping
                if(nums[i] == nums[idx]){
                    i++;
                }else{
                    swap(i, idx, nums);
                }
            }
        }

        for(int k=0; k<n; k++){
            if(k != nums[k]-1){
                return k+1;
            }   
        }
        return n+1;
    }
}

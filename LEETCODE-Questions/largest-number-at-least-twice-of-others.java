class Solution {
    
    public int brute(int[] arr, int n){
        int max = -1;
        int idx = 0;

        for(int i=0; i<n; i++){
            if(arr[i] > max){
                max = arr[i];
                idx = i;
            }
        }

        for(int num: arr){
            if(num == max) continue;

            if(num * 2 > max){
                return -1;
            }
        }

        return idx;
    }

    public int optimal(int[] nums, int n){
        int max1 = -1;
        int max2 = -1;
        int idx = 0;

        for(int i=0; i<n; i++){
            if(nums[i] > max1){
                max2 = max1;
                max1 = nums[i];
                idx = i;
            }else if(nums[i] < max1 && nums[i] > max2){
                max2 = nums[i];
            }
        }

        // System.out.println(max1 + " " + max2);
        // System.out.println(idx);
        return max2 * 2 > max1 ? -1 : idx;
    }

    public int dominantIndex(int[] nums) {
        int n = nums.length;

        // Optimal Approach -> But two passes
        // TC: O(N) + O(N) ~ O(N), SC: O(1)
        // return brute(nums, n);

        // Optimal Approach -> Only Single Pass
        // TC: O(N) + O(N) ~ O(N), SC: O(1)
        return optimal(nums, n);
    }
}

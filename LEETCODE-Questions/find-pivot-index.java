class Solution {
    public int[] prefixSum(int[] nums, int n){
        int[] pfSum = new int[n];
        pfSum[0] = nums[0];

        for(int i=1; i<n; i++){
            pfSum[i] = pfSum[i-1] + nums[i];
        }

        return pfSum;
    }

    public int[] suffixSum(int[] nums, int n){
        int[] sfSum = new int[n];
        sfSum[n-1] = nums[n-1];

        for(int i=n-2; i>=0; i--){
            sfSum[i] = sfSum[i+1] + nums[i];
        }

        return sfSum;
    }

    public int better(int[] nums, int n){
        if(n == 1) return 0;

        int[] pfSum = prefixSum(nums, n);
        int[] sfSum = suffixSum(nums, n);

        if(sfSum[1] == 0) return 0;
        
        for(int i=1; i<n-1; i++){
            int leftSum = pfSum[i-1];
            int rightSum = sfSum[i+1];
            if(leftSum == rightSum) return i;
        }

        if(pfSum[n-2] == 0) return n-1;

        return -1;
    }

    public int optimal(int[] nums, int n){
        int[] pfSum = prefixSum(nums, n);

        // for(int i=0; i<n; i++){
        //     int leftSum = i > 0 ? pfSum[i-1] : 0;
        //     int rightSum = pfSum[n-1] - pfSum[i];
        //     if(leftSum == rightSum) return i;
        // }

        if((pfSum[n-1] - pfSum[0]) == 0) return 0;

        for(int i=1; i<n-1; i++){
            int leftSum = pfSum[i-1];
            int rightSum = pfSum[n-1] - pfSum[i];
            if(leftSum == rightSum) return i;
        }

        if(pfSum[n-2] == 0) return n-1;

        return -1;
    }

    public int pivotIndex(int[] nums) {
        int n = nums.length;

        // Brute Approach (Straightforward Approach)
        // Iterate through each element, and find the left sum and right sum and check
        // whether its equal or not

        // Better Approach - (with 2 functions)
        // TC: O(N), SC: O(N)
        // return better(nums, n);

        // Optimal Approach - (with 1 function)
        // TC: O(N), SC: O(N)
        return optimal(nums, n);
    }
}

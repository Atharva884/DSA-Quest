// Brute Approach
// class NumArray {
//     int[] arr;
//     // TC: O(N), SC: O(N)
//     public NumArray(int[] nums) {
//         int n = nums.length;
//         arr = new int[n];
//         for(int i=0; i<n; i++) arr[i] = nums[i];
//     }
    
//     // TC: O(N), SC: O(1)
//     public int sumRange(int left, int right) {
//         int sum = 0;
//         for(int i=left; i<=right; i++){
//             sum += arr[i];
//         }

//         return sum;
//     }
// }

// Optimal Approach
class NumArray {
    // TC: O(N), SC: O(N)
    int[] pfSum;
    public NumArray(int[] nums) {
        int n = nums.length;
        pfSum = new int[n];
        pfSum[0] = nums[0];

        for(int i=1; i<n; i++){
            pfSum[i] = pfSum[i-1] + nums[i];
        }
    }
    
    // TC: O(1), SC: O(1)
    public int sumRange(int left, int right) {
        if(left == 0) return pfSum[right];

        return pfSum[right] - pfSum[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

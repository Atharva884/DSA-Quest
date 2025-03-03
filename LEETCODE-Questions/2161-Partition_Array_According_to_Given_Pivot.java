class Solution {
    // Brute Approach
    // TC: O(N), SC: O(2N)
    // public int[] pivotArray(int[] nums, int pivot) {
    //     int n = nums.length;
        
    //     ArrayList<Integer> less = new ArrayList<>();
    //     ArrayList<Integer> equal = new ArrayList<>();
    //     ArrayList<Integer> greater = new ArrayList<>();

    //     for(int num: nums){
    //         if(num < pivot){
    //             less.add(num);
    //         }else if(num > pivot){
    //             greater.add(num);
    //         }else{
    //             equal.add(num);
    //         }
    //     }

    //     int[] ans = new int[n];
    //     int k = 0;

    //     for(int val: less){
    //         ans[k++] = val;
    //     }

    //     for(int val: equal){
    //         ans[k++] = val;
    //     }

    //     for(int val: greater){
    //         ans[k++] = val;
    //     }

    //     return ans;
    // }

    // TC: O(N), SC: O(1)
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;
        int i = 0, j = n - 1;

        while (i < n && j >= 0) {
            if (nums[i] < pivot) {
                result[left++] = nums[i];
            }
            if (nums[j] > pivot) {
                result[right--] = nums[j];
            }
            i++;
            j--;
        }

        while (left <= right) {
            result[left++] = pivot;
        }

        return result;
    }
}
class Solution {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void rev(int[] nums, int i, int n){
        int a = i;
        int b = n;

        while(a < b){
            swap(nums, a, b);

            a++;
            b--;
        }
    }

    public int findBreakdown(int[] nums, int n){
        int idx = -1;

        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                idx = i;
                break;
            }
        }

        return idx;
    }

    public int findGreatest(int[] nums, int n, int idx){
        for(int i=n-1; i>=idx; i--){
            if(nums[i] > nums[idx]){
                return i;
            }
        }

        return -1;
    }

    // TC: O(N), SC: O(1)
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int idx = findBreakdown(nums, n);

        if(idx == -1){
            rev(nums, 0, n-1);
            return;
        }

        int numIdx = findGreatest(nums, n, idx);

        swap(nums, idx, numIdx);

        rev(nums, idx+1, n-1);
    }
}

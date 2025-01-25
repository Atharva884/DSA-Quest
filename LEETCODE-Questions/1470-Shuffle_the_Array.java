class Solution {
    // TC: O(N), O(1)
    public int[] shuffle(int[] nums, int n) {
        int len = nums.length;

        int[] ans = new int[len];

        int i = 0;
        int j = n;
        int k = 0;

        while(i < n && j < len){
            ans[k] = nums[i];
            k++;
            ans[k] = nums[j];
            k++;

            i++;
            j++;
        }

        return ans;
    }
}
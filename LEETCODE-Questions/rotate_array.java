class Solution {
    public void brute(int[] nums, int k){
        int n = nums.length;
        int[] ans = new int[n];

        int shift = k;
        if(k > n){
            shift = k % n;
        }

        int idx = 0;
        for(int i=n-shift; i<n; i++){
            ans[idx++] = nums[i];
        }

        for(int i=0; i<n-shift; i++){
            ans[idx++] = nums[i];
        }

        for(int i=0; i<n; i++){
            nums[i] = ans[i];
        }
    }

    public static void swap(int[] arr, int sp, int ep){
        int temp = arr[sp];
        arr[sp] = arr[ep];
        arr[ep] = temp;
    }

    public void reversePart(int[] nums, int sp, int ep){
        while(sp < ep){
            swap(nums, sp, ep);
            
            sp++;
            ep--;
        }
    }

    public void optimal(int[] nums, int k){
        int n = nums.length;

        int shift = k;
        if(k > n){
            shift = k % n;
        }

        reversePart(nums, 0, n-shift-1);
        reversePart(nums, n-shift, n-1);   
        reversePart(nums, 0, n-1);        
    }

    public void rotate(int[] nums, int k) {
        // Brute Approach
        // TC: O(N), SC: O(N)
        // brute(nums, k);

        // Optimal Approach
        // TC: O(N), SC: O(1)
        optimal(nums, k);
    }
}

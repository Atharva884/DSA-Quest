class Solution {
    public int[] brute(int[] nums, int n){
        int[] pos = new int[n/2];
        int[] neg = new int[n/2];

        int a = 0;
        int b = 0;
        for(int i=0; i<n; i++){
            if(nums[i] > 0) pos[a++] = nums[i];
            else neg[b++] = nums[i];
        }

        int[] ans = new int[n];
        int i = 0;
        int j = 0;

        for(int k=0; k<n; k++){
            if(k % 2 == 0){
                ans[k] = pos[i++]; 
            }else{
                ans[k] = neg[j++];
            }
        }

        return ans;
    }

    public int[] optimal1(int[] nums, int n){
        int i = 0;
        int j = 0;

        int[] ans = new int[n];

        for(int k=0; k<n; k++){
            if(k % 2 == 0){
                while(nums[i] < 0) i++;
                ans[k] = nums[i];
                i++;
            }else{
                while(nums[j] > 0) j++;
                ans[k] = nums[j];
                j++;
            }
        }

        return ans;
    }

    public int[] optimal2(int[] nums, int n){
        int[] ans = new int[n];

        int a = 0;
        int b = 1;
        for(int i=0; i<n; i++){
            if(nums[i] < 0){
                ans[b] = nums[i];
                b+=2;
            }else{
                ans[a] = nums[i];
                a+=2;
            }
        }

        return ans;
    }

    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        // Brute Approach
        // TC: O(N+N) ~ O(N), SC: O(N)
        // return brute(nums, n);

        // Optimal Approach - Not much intutive
        // TC: O(N), SC: O(N) 
        // return optimal1(nums, n);

        // Optimal Approach - Much intutive
        // TC: O(N), SC: O(N)
        return optimal2(nums, n);
    }
}

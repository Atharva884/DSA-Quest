class Solution {
    public int brute(int[] nums, int k) {
        int n = nums.length;
        int max = 0;

        for (int sp = 0; sp < n; sp++) {
            int zeroes = 0;
            for (int ep = sp; ep < n; ep++) {
                int num = nums[ep];
                if (num == 0) zeroes++;
                if (zeroes <= k) max = Math.max(max, ep - sp + 1);
            }
        }

        return max;
    }

    public int better(int[] nums, int k) {
        int n = nums.length;

        int sp = 0;
        int ep = 0;

        int max = 0;
        int zeroes = 0;

        while (ep < n) {
            int next = nums[ep];
            if (next == 0)
                zeroes++;

            // Release if no of zeroes > k
            while (sp < n && zeroes > k) {
                int num = nums[sp];
                if (num == 0) {
                    zeroes--;
                }

                sp++;
            }

            if(zeroes <= k) max = Math.max(max, ep - sp + 1);
            ep++;
        }

        return max;
    }

    public int optimal(int[] nums, int k){
        int n = nums.length;

        int sp = 0;
        int ep = 0;

        int max = 0;
        int zeroes = 0;

        while (ep < n) {
            int next = nums[ep];
            if (next == 0)
                zeroes++;

            // Release if no of zeroes > k
            if(sp < n && zeroes > k) {
                int num = nums[sp];
                if (num == 0) {
                    zeroes--;
                }

                sp++;
            }

            if(zeroes <= k) max = Math.max(max, ep - sp + 1);
            ep++;
        }

        return max;
    }

    public int longestOnes(int[] nums, int k) {
        // Brute Approach
        // Generate all the subarrays whose no of zeros are <= k and find the longest 
        // out of it.
        // TC: O(N^2), SC: O(1)
        // return brute(nums, k);

        // Better Approach
        // TC: O(N+N) ~ O(2N), SC: O(1)
        // return better(nums, k);

        // Optimal Approach
        // TC: O(N), SC: O(1)
        return optimal(nums, k);
    }
}

class Solution {
    public int brute(int[] nums, int k){
        int n = nums.length;
        int count = 0;

        for(int sp=0; sp<n; sp++){
            int odd = 0;
            for(int ep=sp; ep<n; ep++){
                int num = nums[ep];
                if(num % 2 != 0) odd++;

                if(odd == k) count++;
            }
        }

        return count;
    }

    public int better(int[] nums, int k){
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int ep = 0;
        int pfSum = 0;
        int count = 0;

        while(ep < n){
            pfSum += nums[ep];
            int diff = pfSum - k;

            if(map.containsKey(diff)){
                count += map.getOrDefault(diff, 0);
            }

            map.put(pfSum, map.getOrDefault(pfSum, 0) + 1);
            ep++;
        }

        return count;
    }

    public int oddSubarrayLessThanEqualtoK(int[] nums, int n, int k){
        int sp = 0;
        int ep = 0;
        int odd = 0;
        int count = 0;

        while(ep < n){
            if(nums[ep] % 2 != 0) odd++;

            while(odd > k){
                if(nums[sp] % 2 != 0){
                    odd--;
                }
                sp++;
            }

            count += (ep - sp + 1);
            ep++;
        }

        return count;
    }

    public int optimal(int[] nums, int k){
        int n = nums.length;

        int a = oddSubarrayLessThanEqualtoK(nums, n, k);
        int b = oddSubarrayLessThanEqualtoK(nums, n, k-1);

        return a - b;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;

        // Brute Approach - TLE
        // TC: O(N^2), SC: O(1)
        // return brute(nums, k);

        // Better Approach - Just twisted the problem (Subarray with sum equal to K)
        // TC: O(N + N) ~ O(2N), SC: O(N + N) for storing the arr of size n
        // int[] arr = new int[n];
        // for(int i=0; i<n; i++){
        //     arr[i] = nums[i] % 2 != 0 ? 1 : 0;
        // }

        // return better(arr, k);

        // Optimal Approach
        // TC: O(2 * 2N), SC: O(1)
        return optimal(nums, k);
    }
}

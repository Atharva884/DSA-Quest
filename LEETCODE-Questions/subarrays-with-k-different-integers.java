class Solution {
    public int brute(int[] nums, int k){
        int n = nums.length;
        int count = 0;

        for(int sp=0; sp<n; sp++){
            HashSet<Integer> hs = new HashSet<>();
            for(int ep=sp; ep<n; ep++){
                hs.add(nums[ep]);

                if(hs.size() == k) count++;
            }
        }

        return count;
    }

    public int subarrayWithKDiffInt(int[] nums, int k){
        int n = nums.length;

        int sp = 0;
        int ep = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(ep < n){
            map.put(nums[ep], map.getOrDefault(nums[ep], 0) + 1);

            while(map.size() > k){
                map.put(nums[sp], map.get(nums[sp]) - 1);
                if(map.get(nums[sp]) == 0) map.remove(nums[sp]);

                sp++;
            }

            if(map.size() <= k) count += (ep - sp + 1);
            ep++;
        }

        return count;
    }

    public int optimal(int[] nums, int k){
        int n = nums.length;

        int a = subarrayWithKDiffInt(nums, k);
        int b = subarrayWithKDiffInt(nums, k - 1);

        return a - b;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        // Brute Approach - TLE
        // TC: O(N^2), SC: O(k)
        // return brute(nums, k);

        // Optimal Approach
        // TC: O(2 * 2N), SC: O(k)
        return optimal(nums, k);
    }

}

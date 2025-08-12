class Solution {
    public int brute(int[] nums, int goal){
        int n = nums.length;
        int count = 0;

        for(int sp=0; sp<n; sp++){
            int sum = 0;
            for(int ep=sp; ep<n; ep++){
                sum += nums[ep];

                if(sum == goal) count++;
            }
        }

        return count;
    }

    public int optimal(int[] nums, int goal){
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int ep = 0;
        int pfSum = 0;
        int count = 0;

        while(ep < n){
            pfSum += nums[ep];
            int diff = pfSum - goal;

            if(map.containsKey(diff)){
                count += map.getOrDefault(diff, 0);
            }

            map.put(pfSum, map.getOrDefault(pfSum, 0) + 1);
            ep++;
        }

        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        // Brute Approach
        // TC: O(N^2), SC: O(1)
        // return brute(nums, goal);

        // Optimal Approach
        // TC: O(N), SC: O(N)
        return optimal(nums, goal);
    }
}

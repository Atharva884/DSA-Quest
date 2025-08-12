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

    public int better(int[] nums, int goal){
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

    public int countSubarrayLessthanEqualtoGoal(int[] nums, int goal){
        int n = nums.length;

        if(goal < 0) return 0;

        int sp = 0;
        int ep = 0;
        int count = 0;
        int sum = 0;

        while(ep < n){
            sum += nums[ep];

            while(sum > goal){
                sum -= nums[sp];
                sp++;
            }

            if(sum <= goal) count += (ep - sp + 1);
            ep++; 
        }

        return count;
    }

    public int optimal(int[] nums, int goal){
        int n = nums.length;

        // Simple Idea
        // find the count of subarray with less than equal to goal then just subtract
        // the count of subarray with less than equal to (goal - 1)
        // As count <= goal - 1 is a subarray of count <= goal
        int a = countSubarrayLessthanEqualtoGoal(nums, goal);
        int b = countSubarrayLessthanEqualtoGoal(nums, goal - 1);

        return a - b;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        // Brute Approach
        // TC: O(N^2), SC: O(1)
        // return brute(nums, goal);

        // Better Approach
        // TC: O(N+N) ~ O(2N), SC: O(N)
        // return optimal(nums, goal);

        // Optimal Approach 
        // As the problem contains all the elements of the array as binary then 
        // we can further optimize it
        // TC: O(2 * (2N)), SC: O(1)
        return optimal(nums, goal);
    }
}

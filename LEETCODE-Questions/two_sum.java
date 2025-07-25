class Solution {
    public int[] brute(int[] nums, int n, int target){
        int[] ans = new int[2];

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int sum = nums[i] + nums[j];
                if(sum == target){
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        return ans;
    }

    public int[] optimal(int[] nums, int n, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for(int i=0; i<n; i++){
            map.put(nums[i], i);
        }

        for(int i=0; i<n; i++){
            int num = nums[i];
            int toFind = target - num;
            if(map.containsKey(toFind) && map.get(toFind) != i){
                ans[0] = i;
                ans[1] = map.get(toFind);
            }
        }

        return ans;
    }

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        // Brute Approach
        // TC: O(N^2), SC: O(1)
        // return brute(nums, n, target);

        // Optimal Approach
        // TC: O(N), SC: O(N)
        return optimal(nums, n, target);
    }
}

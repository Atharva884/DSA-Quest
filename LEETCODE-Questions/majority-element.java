class Solution {
    public int brute(int[] nums, int n){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        int val = 0;
        for(int key: map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
                val = key;
            }
        }

        return val;
    }

    public int optimal(int[] nums, int n){
        int val = nums[0];
        int count = 1;

        for(int i=1; i<n; i++){
            if(nums[i] == val){
                count++;
            }else{
                if(count == 0){
                    val = nums[i];
                    count = 1;
                }else{
                    count--;
                }
            }
        }

        return val;
    }

    public int majorityElement(int[] nums) {
        int n = nums.length;

        // Brute Force Approach
        // O(N+N) ~ O(N), SC: O(N)
        // return brute(nums, n);

        // Optimal Approach
        // O(N), SC: O(1)
        return optimal(nums, n);
    }
}

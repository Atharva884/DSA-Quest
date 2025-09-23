class Solution {
    public List<Integer> brute(int[] nums, int n){
        List<Integer> ans = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int key: map.keySet()){
            if(map.get(key) > n/3){
                ans.add(key);
            }
        }

        return ans;
    }

    public int countOcc(int num, int[] nums, int n){
        int count = 0;

        for(int i=0; i<n; i++){
            if(nums[i] == num) count++;
        }

        return count;
    }

    public List<Integer> optimal(int[] nums, int n){
        List<Integer> ans = new ArrayList<>();

        int val1 = nums[0];
        int count1 = 1;

        int val2 = Integer.MIN_VALUE;
        int count2 = 0;

        for(int i=1; i<n; i++){
            if(nums[i] == val1){
                count1++;
            }else if(nums[i] == val2){
                count2++;
            }else if(count1 == 0){
                val1 = nums[i];
                count1 = 1;
            }else if(count2 == 0){
                val2 = nums[i];
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }

        int valid1 = countOcc(val1, nums, n);
        int valid2 = countOcc(val2, nums, n);

        if(valid1 > n/3) ans.add(val1);
        if(valid2 > n/3) ans.add(val2);

        return ans;
    }

    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        // Brute Force Approach
        // TC: O(N+N) ~ O(2N), SC: O(N)
        // return brute(nums, n);

        // Optimal Approach
        // TC: O(N), SC: O(1) as list<Integer> is the output expected
        return optimal(nums, n);
    }
}

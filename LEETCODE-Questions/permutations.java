class Solution {
    public void solve(int[] nums, int n, List<List<Integer>> ans, HashMap<Integer, Integer> map, List<Integer> temp){
        if(temp.size() == n){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0; i<n; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                temp.add(nums[i]);
                solve(nums, n, ans, map, temp);
                map.remove(nums[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public List<List<Integer>> brute(int[] nums){
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> temp = new ArrayList<>();

        solve(nums, n, ans, map, temp);

        return ans;
    }

    public void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void solve1(int i, int[] nums, int n, List<List<Integer>> ans){
        if(i == n){
            List<Integer> temp = new ArrayList<>();
            for(int num: nums){
                temp.add(num);
            }
            ans.add(temp);
            return;
        }

        for(int idx=i; idx<n; idx++){
            swap(i, idx, nums);
            solve1(i+1, nums, n, ans);
            swap(i, idx, nums);
        }
    }

    public List<List<Integer>> optimal(int[] nums){
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        solve1(0, nums, n, ans);

        return ans;
    }

    public List<List<Integer>> permute(int[] nums) {
        // Brute Approach
        // TC: O(N! * N), SC: O(N + N) ~ O(2N)
        // return brute(nums);

        // Optimal Approach
        // TC: O(N! * N), SC: O(N) 
        return optimal(nums);
    }
}

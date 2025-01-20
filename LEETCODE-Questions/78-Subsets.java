class Solution {
    public void solve(int i, int[] nums, HashSet<Integer> hs, HashSet<HashSet<Integer>> ans){
        if(i < 0){
            ans.add(new HashSet<>(hs));
            return;
        }

        solve(i-1, nums, hs, ans);

        hs.add(nums[i]);
        solve(i-1, nums, hs, ans);
        hs.remove(nums[i]);
    }

    // Brute Force Approach
    // TC: O(2 ^ N), SC: O(1)
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;

        HashSet<HashSet<Integer>> ans = new HashSet();
        HashSet<Integer> hs = new HashSet<>();

        solve(n-1, nums, hs, ans);

        List<List<Integer>> res = new ArrayList();
        for(HashSet<Integer> key: ans){
            res.add(new ArrayList<>(key));
        }

        return res;
    }
}
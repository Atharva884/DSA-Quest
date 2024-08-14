class Solution {
    public static void solve(int idx, int target, int[] can, List<List<Integer>> ans, List<Integer> arr) {
        // Base case
        // We have found the combination
        if (target == 0) {
            ans.add(new ArrayList<>(arr));
            return;
        }

        if (idx >= can.length)
            return;

        // Main logic

        if (can[idx] <= target) {
            arr.add(can[idx]);
            solve(idx, target - can[idx], can, ans, arr);
            arr.remove(arr.size() - 1);
        }

        // Pick the element if the arr[idx] <= target
        solve(idx + 1, target, can, ans, arr);
        return;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();

        solve(0, target, candidates, ans, arr);

        return ans;
    }
}
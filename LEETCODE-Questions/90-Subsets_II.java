class Solution {
    // public void solve(int i, int[] nums, List<Integer> temp, HashSet<List<Integer>> ans){
    //     if(i < 0){
    //         ans.add(new ArrayList<>(temp));
    //         return;
    //     }

    //     solve(i-1, nums, temp, ans);

    //     temp.add(nums[i]);
    //     solve(i-1, nums, temp, ans);
    //     temp.remove(temp.size() - 1);
    // }

    // Recursion
    // TC: O(2^N * N), SC: O(2^N * N)
    // public List<List<Integer>> subsetsWithDup(int[] nums) {
    //     Arrays.sort(nums);

    //     int n = nums.length;

    //     HashSet<List<Integer>> ans = new HashSet();
    //     List<Integer> temp = new ArrayList<>();

    //     solve(n-1, nums, temp, ans);

    //     List<List<Integer>> res = new ArrayList();
    //     for(List<Integer> key: ans){
    //         res.add(key);
    //     }

    //     return res;
    // }


    public boolean checkBit(int N, int i){
        if((N & (1 << i)) != 0) return true;
        return false;
    }

    // Bit Masking Approach
    // TC: O(2^N * N), SC: O(2^N * N)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        int len = (1 << n);

        HashSet<List<Integer>> res = new HashSet<>();

        for(int i=0; i<len; i++){
            List<Integer> temp = new ArrayList<>();

            for(int j=0; j<n; j++){
                if(checkBit(i, j)){
                    temp.add(nums[j]);
                }
            }

            // Collections.sort(temp);
            res.add(temp);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> key: res){
            ans.add(key);
        }

        return ans;
    }
}

class Solution {
    // public void solve(int i, int[] nums, HashSet<Integer> hs, HashSet<HashSet<Integer>> ans){
    //     if(i < 0){
    //         ans.add(new HashSet<>(hs));
    //         return;
    //     }

    //     solve(i-1, nums, hs, ans);

    //     hs.add(nums[i]);
    //     solve(i-1, nums, hs, ans);
    //     hs.remove(nums[i]);
    // }

    // // Recursion Approach
    // // TC: O(2^N * N), SC: O(2^N * N)
    // public List<List<Integer>> subsets(int[] nums) {
        // int n = nums.length;

        // HashSet<HashSet<Integer>> ans = new HashSet();
        // HashSet<Integer> hs = new HashSet<>();

        // solve(n-1, nums, hs, ans);

        // List<List<Integer>> res = new ArrayList();
        // for(HashSet<Integer> key: ans){
        //     res.add(new ArrayList<>(key));
        // }

        // return res;
    // }

    public boolean checkBit(int N, int i){
        if((N & (1 << i)) != 0) return true;
        return false;
    }


    // Bit Manipulation Concept
    // TC: O(2^N * N), SC: O(2^N * N)

    // Subsequences are ordered collections of elements from the array, but since subsets don't care about order, every subsequence corresponds to a unique subset.
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        int len = (1 << n);

        for(int i=0; i<len; i++){
            List<Integer> temp = new ArrayList<>();

            for(int j=0; j<n; j++){
                if(checkBit(i, j)){
                    temp.add(nums[j]);
                }
            }

            ans.add(temp);
        }    

        return ans;
    }
}
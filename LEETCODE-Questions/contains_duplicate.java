class Solution {
    // TC: O(N), SC: O(N)
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;

        HashSet<Integer> hs = new HashSet<>();
        for(int num: nums){
            if(hs.contains(num)){
                return true;
            }
            hs.add(num);
        }

        return false;
    }
}

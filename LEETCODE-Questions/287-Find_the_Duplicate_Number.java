class Solution {
    // Brute Force Approach
    // TC: O(N), SC: O(N)
    // public int findDuplicate(int[] nums) {
    //     int n = nums.length;

    //     HashSet<Integer> hs = new HashSet<>();

    //     for(int num: nums){
    //         if(hs.contains(num)){
    //             return num;
    //         }

    //         hs.add(num);
    //     }

    //     return -1;
    // }

    // Optimal Approach (Flyod Cycle Detection)
    // TC: O(N), SC: O(1)
    public int findDuplicate(int[] nums){
        int n = nums.length;

        int s = nums[0];
        int f = nums[0];

        while(true){
            s = nums[s];
            f = nums[nums[f]];

            if(s == f){
                break;
            }
        }


        s = nums[0];

        while(s != f){
            s = nums[s];
            f = nums[f];
        }

        return s;
    }
}
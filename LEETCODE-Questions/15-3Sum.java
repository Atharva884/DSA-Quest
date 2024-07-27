import java.util.*;

class Solution {
    // Brute Force Approach
    // public List<List<Integer>> threeSum(int[] nums) {
    // int n = nums.length;
    // HashSet<List<Integer>> map = new HashSet<>();
    // List<List<Integer>> list = new ArrayList<>();

    // for(int i=0; i<n; i++){
    // for(int j=i+1; j<n; j++){
    // for(int k=j+1; k<n; k++){
    // // Get the sum
    // int sum = nums[i] + nums[j] + nums[k];

    // if(sum == 0){
    // ArrayList<Integer> temp = new ArrayList<>();
    // temp.add(nums[i]);
    // temp.add(nums[j]);
    // temp.add(nums[k]);
    // Collections.sort(temp);

    // // It will only store unique elements
    // map.add(temp);
    // }
    // }
    // }
    // }

    // for(List<Integer> val: map){
    // list.add(val);
    // }

    // return list;
    // }

    // Better Approach
    // public List<List<Integer>> threeSum(int[] nums){
    // List<List<Integer>> list = new ArrayList<>();
    // HashSet<Integer> hs = new HashSet<>();
    // HashSet<List<Integer>> map = new HashSet<>();
    // int n = nums.length;

    // for(int i=0; i<n; i++){
    // for(int j=i+1; j<n; j++){
    // // Find the 3rd elem
    // int thirdElem = 0-(nums[i] + nums[j]);

    // if(hs.contains(thirdElem)){
    // // Then we have find our triplet
    // List<Integer> temp = new ArrayList<>();
    // temp.add(nums[i]);
    // temp.add(nums[j]);
    // temp.add(thirdElem);

    // Collections.sort(temp);

    // map.add(temp);
    // }else{
    // // Make sure u add the nums[j] in hashset
    // hs.add(nums[j]);
    // }
    // }
    // hs.clear();
    // }

    // for(List<Integer> val: map){
    // list.add(val);
    // }

    // return list;
    // }

    // Optimal Approach
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    // As array is sorted, increment j pointer
                    j++;
                } else if (sum > 0) {
                    // As array is sorted, decrement k pointer
                    k--;
                } else {
                    // We have found our triplet
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);

                    list.add(temp);

                    j++;
                    k--;

                    while (nums[j] == nums[j - 1] && j < k)
                        j++;

                    while (nums[k] == nums[k + 1] && j < k)
                        k--;
                }
            }
        }

        return list;
    }
}
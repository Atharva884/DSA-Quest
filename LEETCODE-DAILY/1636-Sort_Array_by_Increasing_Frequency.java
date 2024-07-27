import java.util.*;

class Solution {
    // TC: O(N) + O(NlogN) + O(N), SC: O(N)
    // public int[] frequencySort(int[] nums) {
    // int n = nums.length;

    // HashMap<Integer, Integer> map = new HashMap<>();

    // for(int num: nums){
    // map.put(num, map.getOrDefault(num, 0) + 1);
    // }

    // Integer[] arr = new Integer[n];
    // for(int i=0; i<n; i++){
    // arr[i] = nums[i];
    // }

    // Comparator c = new Comparator<Integer>(){
    // public int compare(Integer a, Integer b){
    // if(map.get(a) == map.get(b)){
    // return b-a; // sort in decreasing order based on freq
    // }

    // return map.get(a) - map.get(b); // sort in increasing order based on freq
    // }
    // };

    // Arrays.sort(arr, c);

    // int i = 0;
    // for(Integer a: arr){
    // nums[i++] = a;
    // }

    // return nums;

    // }

    // TC: O(N) + O(klogk + O(N), SC: O(N)
    public int[] frequencySort(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Integer[] arr = new Integer[map.size()];
        int i = 0;

        for (Integer key : map.keySet()) {
            arr[i] = key;
            i++;
        }

        Comparator<Integer> c = new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if (map.get(a) == map.get(b)) {
                    return b - a;
                }

                return map.get(a) - map.get(b);
            }
        };

        Arrays.sort(arr, c);

        i = 0;
        for (int a : arr) {
            int key = map.get(a);

            for (int j = 0; j < key; j++) {
                nums[i++] = a;
            }
        }

        return nums;

    }
}
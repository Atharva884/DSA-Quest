class Solution {
    // Brute Force Approach -> Not optimal
    // TC: O(NlogN), SC: O(N)

    // public static int[] sortArray(int[] nums) {
    // int n = nums.length;

    // TreeMap<Integer, Integer> map = new TreeMap<>();
    // for(int num: nums){
    // map.put(num, map.getOrDefault(num, 0) + 1);
    // }

    // int i = 0;
    // for(Map.Entry<Integer, Integer> entry: map.entrySet()){
    // int key = entry.getKey();
    // int val = entry.getValue();

    // for(int j=0; j<val; j++){
    // nums[i] = key;
    // i++;
    // }
    // }

    // return nums;
    // }

    public static void mergeTwoSortedArr(int[] arr, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        int k = 0;

        int[] res = new int[hi - lo + 1];

        while (i <= mid && j <= hi) {
            if (arr[i] <= arr[j]) {
                res[k++] = arr[i];
                i++;
            } else {
                res[k++] = arr[j];
                j++;
            }
        }

        while (i <= mid) {
            res[k++] = arr[i];
            i++;
        }

        while (j <= hi) {
            res[k++] = arr[j];
            j++;
        }

        k = 0;
        for (int l = lo; l <= hi; l++) {
            arr[l] = res[k++];
        }
    }

    // TC: O(NlogN), SC: O(N)
    public static void mergeSort(int[] arr, int lo, int hi) {
        if (lo == hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        mergeSort(arr, lo, mid);
        mergeSort(arr, mid + 1, hi);

        mergeTwoSortedArr(arr, lo, mid, hi);
    }

    public static int[] sortArray(int[] nums) {
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;

        mergeSort(nums, lo, hi);

        return nums;
    }
}
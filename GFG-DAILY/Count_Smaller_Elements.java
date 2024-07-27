import java.util.*;

class Solution {
    // Brute Force Approach.
    // TC: O(n^2), SC: O(1)

    // int[] constructLowerArray(int[] arr) {
    // int n = arr.length;

    // for(int i=0; i<n; i++){
    // int count = 0;
    // for(int j=i+1; j<n; j++){
    // if(arr[j] < arr[i]){
    // count++;
    // }
    // }
    // arr[i] = count;
    // }

    // return arr;
    // }

    // Optimal Approach.
    // TC: O(n*logn), SC: O(N)

    public static int searchInsertPos(ArrayList<Integer> arr, int key) {
        int lo = 0;
        int hi = arr.size() - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            // if(arr[mid] == key){
            // return mid - 1;
            // }
            if (arr.get(mid) >= key) {
                hi = mid - 1;
            } else if (arr.get(mid) < key) {
                lo = mid + 1;
            }
        }

        return lo;
    }

    int[] constructLowerArray(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        ArrayList<Integer> sortedArr = new ArrayList<>();

        // You know, there is last element and will be 0 for all arrays
        sortedArr.add(arr[n - 1]);
        ans[n - 1] = 0;

        int x = n - 2;

        for (int i = n - 2; i >= 0; i--) {
            // System.out.println("hello");

            int key = arr[i];

            int idx = searchInsertPos(sortedArr, key);

            sortedArr.add(idx, key);

            ans[x--] = idx;
        }

        return ans;

    }

}
class Solution {
    public static int min(int[] arr) {
        int min = Integer.MAX_VALUE;

        for (int val : arr) {
            min = Math.min(val, min);
        }

        return min;
    }

    public static int max(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int val : arr) {
            max = Math.max(max, val);
        }

        return max;
    }

    public int calBouquet(int[] arr, int day, int k) {
        int n = arr.length;

        int i = 0;
        int ans = 0;

        int count = 0;
        while (i < n) {
            if (arr[i] <= day) {
                count++;
            } else {
                count = 0;
            }

            if (count == k) {
                ans++;
                count = 0;
            }

            i++;
        }

        return ans;
    }

    // TC: O(log(max - min) * N), SC: O(1)
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if ((m * k) > n)
            return -1;

        int lo = min(bloomDay);
        int hi = max(bloomDay);
        int ans = -1;

        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);

            int bouquet = calBouquet(bloomDay, mid, k);

            if (bouquet >= m) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }
}
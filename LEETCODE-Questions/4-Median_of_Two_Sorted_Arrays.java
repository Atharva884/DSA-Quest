class Solution {
    // public int[] mergeTwoSortedArray(int[] a, int[] b, int n1, int n2){
    //     int[] ans = new int[n1 + n2];

    //     int i = 0;
    //     int j = 0;
    //     int k = 0;

    //     while(i < n1 && j < n2){
    //         if(a[i] <= b[j]){
    //             ans[k++] = a[i++];
    //         }else{
    //             ans[k++] = b[j++];
    //         }
    //     }

    //     while(i < n1){
    //         ans[k++] = a[i++];
    //     }

    //     while(j < n2){
    //         ans[k++] = b[j++];
    //     }

    //     return ans;
    // }

    // Better Approach
    // TC: O(n1 + n2), SC: O(n1 + n2) 
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     int n1 = nums1.length;
    //     int n2 = nums2.length;

    //     int[] ans = mergeTwoSortedArray(nums1, nums2, n1, n2);

    //     int n = n1 + n2;

    //     if(n % 2 == 0){
    //         // Even
    //         int mid1 = n / 2;
    //         int mid2 = mid1 - 1;

    //         return (double) (ans[mid1] + ans[mid2]) / 2.0;
    //     }else{
    //         // Odd
    //         return ans[n / 2];
    //     }
    // }

    // Optimal Approach
    // TC: O(min(logN, logM)), SC: O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int n = n1 + n2;

        int lo = 0;
        int hi = n1;
        int left = (n + 1) / 2;

        while(lo <= hi){
            int mid1 = lo + ((hi - lo) >> 1);
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(mid1 < n1) r1 = nums1[mid1];
            if(mid2 < n2) r2 = nums2[mid2];
            if(mid1 - 1 >= 0) l1 = nums1[mid1 - 1];
            if(mid2 - 1 >= 0) l2 = nums2[mid2 - 1];

            if(l1 <= r2 && l2 <= r1){
                if((n & 1) == 0){
                    // Even
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }else{
                    // Odd
                    return (double) Math.max(l1, l2);
                }
            }else if(l1 > r2){
                hi = mid1 - 1;
            }else{
                lo = mid1 + 1;
            }
        }

        return 0;
    }
}
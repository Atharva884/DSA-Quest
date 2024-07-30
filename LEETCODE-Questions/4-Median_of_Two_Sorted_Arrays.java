class Solution {    
    public double findMedianSortedArrays(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;

        if (n > m) {
            return findMedianSortedArrays(b, a);
        }

        int lo = 0;
        int hi = n;
        int left = (n + m + 1) / 2;

        int len = n + m;

        while (lo <= hi) {
            int mid1 = lo + (hi - lo) / 2;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if (mid1 < n)
                r1 = a[mid1];
            if (mid2 < m)
                r2 = b[mid2];
            if (mid1 - 1 >= 0)
                l1 = a[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = b[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                if (len % 2 == 1) {
                    // ! Odd
                    return Math.max(l1, l2);
                } else {
                    // ! Even
                    return (Math.max(l1, l2) + Math.min(r1, r2))/ 2.0;
                }
            }else if(l1 > r2){
                hi = mid1 - 1;
            }else{
                lo = mid1 + 1;
            }
                
        }

        return 0.0;
    }
}
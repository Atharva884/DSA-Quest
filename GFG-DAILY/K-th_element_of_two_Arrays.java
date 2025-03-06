// User function Template for Java

class Solution {
    // TC: O(log(Math.min(a, b))), SC: O(1)
    public int kthElement(int a[], int b[], int k) {
        int n1 = a.length;
        int n2 = b.length;
        
        if(n1 > n2) return kthElement(b, a, k);
        
        int lo = Math.max(0, k - n2);
        int hi = Math.min(n1, k);
        
        int left = k;
        
        while(lo <= hi){
            int mid1 = lo + ((hi - lo) >> 1);
            int mid2 = left - mid1;
            
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            
            if(mid1 < n1) r1 = a[mid1];
            if(mid2 < n2) r2 = b[mid2];
            if(mid1 - 1 >= 0) l1 = a[mid1 - 1];
            if(mid2 - 1 >= 0) l2 = b[mid2 - 1];
            
            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1, l2);
            }else if(l1 > r2){
                hi = mid1 - 1;
            }else{
                lo = mid1 + 1;
            }
        }
        
        return 0;
    }
}
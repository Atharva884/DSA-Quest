class Solution {
    public int mySqrt(int x) {
        int lo = 0;
        int hi = x-1;
        int ans = 0;

        while(lo <= hi){
            int m = lo + ((hi - lo) >> 1);
            long val = (long) (m+1) * (m+1);

            if(val > x){
                hi = m - 1;
            }else if(val < x){
                ans = m+1;
                lo = m + 1;
            }else{
                return m+1;
            }
        }

        return ans;
    }
}
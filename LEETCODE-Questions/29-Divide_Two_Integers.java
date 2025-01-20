class Solution {
    // TC: O(32), SC: O(1)
    public int divide(int dividend, int divisor) {
        long a = dividend;
        long b = divisor;

        // Special Case hai
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int sign = 1;
        if(a < 0) sign = sign * -1;
        if(b < 0) sign = sign * -1;

        a = Math.abs(a);
        b = Math.abs(b);

        long temp = 0;
        long q = 0;

        for(int i=31; i>=0; i--){
            if(temp + (b << i) <= a){
                temp = temp + (b<<i);
                q = q + (1 << i);
            }
        }

        if(sign < 0) return (int) -q;

        if(q < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if(q > Integer.MAX_VALUE) return Integer.MAX_VALUE;

        return (int) q;
    }
}
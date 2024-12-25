class Solution {
    public static double solve(double a, int n){
        if(n == 1){
            return a;
        }

        double temp = solve(a, n/2);
        if(n % 2 == 0){
            return temp * temp;
        }

        return temp * temp * a;
    }

    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }

        if (n == Integer.MIN_VALUE) {
            // Special case for Integer.MIN_VALUE to avoid overflow
            x = x * x; // x^(n/2) will become x^(Integer.MIN_VALUE/2)
            n = n / 2;  // Adjust n to be positive
        }

        if(n < 0){
            return (1 / solve(x, -n)); 
        }

        return solve(x, n);
    }
}
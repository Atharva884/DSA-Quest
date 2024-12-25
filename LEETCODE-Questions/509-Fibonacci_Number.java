class Solution {
    public static int solve(int n){
        if(n == 0){
            return 0;
        }

        if(n == 1){
            return 1;
        }

        int a = solve(n-1);
        int b = solve(n-2);

        return a + b;
    }

    public int fib(int n) {
        return solve(n);
    }
}
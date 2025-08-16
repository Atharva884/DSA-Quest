class Solution {
    // Optimal Approach
    // TC: O(log10(N)), SC: O(1) 
    public boolean isPalindrome(int n) {
        if(n < 0) return false;

        int dup = n;

        int rev = 0;
        while(n != 0){
            int lastDigit = n % 10;
            n = n / 10;
            rev = (rev * 10) + lastDigit;
        }

        return rev == dup ? true : false;
    }
}

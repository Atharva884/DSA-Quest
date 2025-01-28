class Solution {
    // TC: O(log(x)), SC: O(1)  
    public int reverse(int x) {
        long num = 0;

        while(x != 0){
            long lastDigit = x % 10;

            num = num * 10 + lastDigit;

            if(num < Integer.MIN_VALUE || num > Integer.MAX_VALUE) return 0;    

            x = x / 10;     
        }

        return (int) num;
    }
}
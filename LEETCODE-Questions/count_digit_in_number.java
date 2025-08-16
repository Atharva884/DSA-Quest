class Solution {
    // Optimal ApproacH
    // TC: O(N), SC: O(1)
    public int countDigits(int n) {
        int count = 0;
        
        while(n != 0){
            count++;
            n = n / 10;
        }
        
        return count;
    }
}

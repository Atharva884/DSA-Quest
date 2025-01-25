class Solution {
    // Optimal Approach
    // TC: O(max(n, m)), SC: O(max(n, m))
    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();
        StringBuilder sb = new StringBuilder();

        int carry = 0;
        int i = n-1;
        int j = m-1;

        while(i >= 0 || j >= 0){
            int sum = carry;

            if(i >= 0){
                // Converting char to int
                sum += a.charAt(i) - '0';
                i--;
            }

            if(j >= 0){
                sum += b.charAt(j) - '0';
                j--;
            }

            // When u are dealing with the binary i.e base 2, to get val (mod by 2) and to
            // update carry (divide by 2);
            sb.append(sum % 2);
            carry = sum / 2;
        }

        if(carry == 1){
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
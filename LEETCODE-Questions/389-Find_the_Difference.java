class Solution {
    // TC: O(n+m), SC: O(1)
    public char findTheDifference(String s, String t) {
        int n = s.length();
        int m = t.length();

        int xor = 0;

        // for(int i=0; i<n; i++){
        // xor ^= (int) s.charAt(i);
        // }

        // for(int i=0; i<m; i++){
        // xor ^= (int) t.charAt(i);
        // }

        for (int i = 0; i < m; i++) {
            if (i == m - 1) {
                xor ^= (int) t.charAt(i);
                continue;
            }

            xor ^= ((int) s.charAt(i) ^ (int) t.charAt(i));
        }

        return (char) xor;
    }

}
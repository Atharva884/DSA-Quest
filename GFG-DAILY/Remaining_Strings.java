class Solution {
    public String printString(String s, char ch, int count) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ch && count > 0) {
                count--;
                continue;
            }
            if (count == 0) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
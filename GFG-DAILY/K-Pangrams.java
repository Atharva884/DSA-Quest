import java.util.*;

class Solution {
    // TC: O(N), SC: O(N)
    boolean kPangram(String str, int k) {
        String st = str.replaceAll("\\s+", "");
        int n = st.length();

        HashSet<Character> hs = new HashSet<>();
        for (int i = 97; i <= 122; i++) {
            hs.add((char) i);
        }

        if (n < 26) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            char c = st.charAt(i);

            if (hs.contains(c)) {
                hs.remove(c);
                count++;
            }
        }

        int lowerCaseLetters = 26;

        if (count >= lowerCaseLetters) {
            return true;
        } else {
            if ((lowerCaseLetters - count) <= k) {
                return true;
            }
        }

        return false;
    }
}
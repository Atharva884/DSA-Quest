import java.util.*;

class Solution {

    // TC: O(N), SC: O(N)
    String removeDups(String str) {
        HashSet<Character> hs = new HashSet<>();

        int n = str.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (hs.contains(c) == false) {
                sb.append(c);
            }

            hs.add(c);
        }

        return sb.toString();
    }
}
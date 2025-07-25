class Solution {
    // Optimal Approach
    // TC: O(S), SC: O(S)
    public String minWindow(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();

        if (n2 > n1)
            return "";

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int ansLen = Integer.MAX_VALUE;
        int sp = 0;
        int ep = 0;
        int matchCount = 0;

        int start = 0;
        int end = 0;

        while (ep < n1) {
            if (matchCount != n2) {
                // Acquire
                char c = s.charAt(ep);
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
                if (sMap.get(c) <= tMap.getOrDefault(c, 0)) {
                    matchCount++;
                }

                ep++;
            } else {
                // Release
                int len = ep - sp;
                if (len < ansLen) {
                    ansLen = len;
                    start = sp;
                    end = ep;
                }

                char c = s.charAt(sp);
                sMap.put(c, sMap.get(c) - 1);
                if (sMap.get(c) < tMap.getOrDefault(c, 0)) {
                    matchCount--;
                }
                if (sMap.get(c) == 0) {
                    sMap.remove(c);
                }

                sp++;
            }
        }

        while (matchCount == n2) {
            // Release
            int len = ep - sp;
            if (len < ansLen) {
                ansLen = len;
                start = sp;
                end = ep;
            }

            char c = s.charAt(sp);
            sMap.put(c, sMap.get(c) - 1);
            if (sMap.get(c) < tMap.getOrDefault(c, 0)) {
                matchCount--;
            }
            if (sMap.get(c) == 0) {
                sMap.remove(c);
            }

            sp++;
        }

        return s.substring(start, end);
    }
}

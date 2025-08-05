class Solution {
    // Optimal Solution
    // TC: O(K + N) ~ O(N), SC: O(N) worst case
    public String minWindow(String s, String t) {
        int n = s.length();
        int k = t.length();

        if (k > n)
            return "";

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int matchCount = 0;

        int sp = 0;
        int ep = 0;

        int start = 0;
        int end = 0;
        int ans = Integer.MAX_VALUE;

        while (ep < n) {
            char next = s.charAt(ep);
            char old = s.charAt(sp);

            if (matchCount != k) {
                // Acquire
                sMap.put(next, sMap.getOrDefault(next, 0) + 1);
                if (sMap.get(next) <= tMap.getOrDefault(next, 0)) {
                    matchCount++;
                }

                ep++;
            } else {
                // Release
                int len = ep - sp;
                if (len < ans) {
                    ans = len;
                    start = sp;
                    end = ep;
                }

                sMap.put(old, sMap.get(old) - 1);
                if (sMap.get(old) < tMap.getOrDefault(old, 0)) {
                    matchCount--;
                }
                if(sMap.get(old) == 0) sMap.remove(old);

                sp++;
            }
        }

        while (matchCount == k) {
            char old = s.charAt(sp);

            // Release
            int len = ep - sp;
            if (len < ans) {
                ans = len;
                start = sp;
                end = ep;
            }

            sMap.put(old, sMap.get(old) - 1);
            if (sMap.get(old) < tMap.getOrDefault(old, 0)) {
                matchCount--;
            }
            if(sMap.get(old) == 0) sMap.remove(old);

            sp++;
        }

        return s.substring(start, end);
    }
}

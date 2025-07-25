class Solution {
    public List<Integer> brute(String s, String p) {
        int n1 = s.length();
        int n2 = p.length();

        HashMap<Character, Integer> pMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < n1; i++) {
            HashMap<Character, Integer> sMap = new HashMap<>();
            int matchCount = 0;

            for (int j = i; j < i + n2 && j < n1; j++) {
                char c = s.charAt(j);
                if (pMap.containsKey(c)) {
                    sMap.put(c, sMap.getOrDefault(c, 0) + 1);
                    if (sMap.get(c) <= pMap.getOrDefault(c, 0)) {
                        matchCount++;
                    }
                }
            }

            if (matchCount == n2) {
                ans.add(i);
            }
        }

        return ans;
    }

    public List<Integer> optimal(String s, String p) {
        int n1 = s.length();
        int n2 = p.length();
        List<Integer> ans = new ArrayList<>();

        if (n2 > n1)
            return ans;

        HashMap<Character, Integer> pMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        int sp = 0;
        int ep = 0;
        int matchCount = 0;

        while (ep < n2) {
            char c = s.charAt(ep);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            if (sMap.get(c) <= pMap.getOrDefault(c, 0)) {
                matchCount++;
            }
            ep++;
        }

        if (matchCount == n2) {
            ans.add(0);
        }

        while (ep < n1) {
            char nextChar = s.charAt(ep);
            char oldChar = s.charAt(sp);

            sMap.put(nextChar, sMap.getOrDefault(nextChar, 0) + 1);
            if (sMap.get(nextChar) <= pMap.getOrDefault(nextChar, 0)) {
                matchCount++;
            }

            sMap.put(oldChar, sMap.getOrDefault(oldChar, 0) - 1);
            if (sMap.get(oldChar) < pMap.getOrDefault(oldChar, 0)) {
                matchCount--;
            }
            if (sMap.get(oldChar) == 0) {
                sMap.remove(oldChar);
            }

            sp++;
            ep++;

            if (matchCount == n2) {
                ans.add(sp);
            }
        }

        return ans;
    }

    public List<Integer> findAnagrams(String s, String p) {
        // Brute Approach
        // TC: O(S * P), SC: O(P)
        // return brute(s, p);

        // Optimal Approach
        // TC: O(S), SC: O(P)
        return optimal(s, p);
    }
}

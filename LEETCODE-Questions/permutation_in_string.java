class Solution {
    // TC: O(k + N) ~ O(N), SC: O(k + K) ~ O(K)
    public boolean checkInclusion(String s1, String s2) {
        int n = s2.length();
        int k = s1.length();

        HashMap<Character, Integer> kMap = new HashMap<>();
        HashMap<Character, Integer> pMap = new HashMap<>();

        if(k > n) return false;

        for(char c: s1.toCharArray()){
            kMap.put(c, kMap.getOrDefault(c, 0) + 1);
        }

        int matchCount = 0;
        for(int i=0; i<k; i++){
            char c = s2.charAt(i);
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
            if(pMap.get(c) <= kMap.getOrDefault(c, 0)){
                matchCount++;
            }
        }

        if(matchCount == k){
            return true;
        }

        int sp = 0;
        int ep = k;

        while(ep < n){
            // Acquire
            char next = s2.charAt(ep);
            pMap.put(next, pMap.getOrDefault(next, 0) + 1);
            if(pMap.get(next) <= kMap.getOrDefault(next, 0)){
                matchCount++;
            }

            // Release
            char old = s2.charAt(sp);
            pMap.put(old, pMap.get(old) - 1);
            if(pMap.get(old) < kMap.getOrDefault(old, 0)){
                matchCount--;
            }
            if (pMap.get(old) == 0) {
                pMap.remove(old);
            }

            if(matchCount == k){
                return true;
            }

            sp++;
            ep++;
        }

        return false;
    }
}

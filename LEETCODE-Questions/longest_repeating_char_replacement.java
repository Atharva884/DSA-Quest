class Solution {
    public int better(String s, int k){
        int n = s.length();

        int sp = 0;
        int ep = 0;
        int max = -1;
        int maxlen = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while(ep < n){
            char next = s.charAt(ep);
            map.put(next, map.getOrDefault(next, 0) + 1);
            max = Math.max(max, map.get(next));

            while((ep - sp + 1) - max > k){
                char old = s.charAt(sp);
                map.put(old, map.get(old) - 1);
                if(map.get(old) == 0) map.remove(old);
                for(char key: map.keySet()) max = Math.max(max, map.get(key));

                sp++;
            }

            maxlen = Math.max(maxlen, ep - sp + 1);
            ep++;
        }

        return maxlen;
    }

    public int optimal(String s, int k){
        int n = s.length();

        int sp = 0;
        int ep = 0;
        int max = -1;
        int maxlen = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while(ep < n){
            char next = s.charAt(ep);
            map.put(next, map.getOrDefault(next, 0) + 1);
            max = Math.max(max, map.get(next));

            if((ep - sp + 1) - max > k){
                char old = s.charAt(sp);
                map.put(old, map.get(old) - 1);
                if(map.get(old) == 0) map.remove(old);
            
                sp++;
            }

            maxlen = Math.max(maxlen, ep - sp + 1);
            ep++;
        }

        return maxlen;
    }
    
    public int characterReplacement(String s, int k) {
        // Better Approach
        // TC: O(N + N) ~ O(2N) * O(K), SC: O(k) where k is a 26 character
        // return better(s, k);

        // Better Approach
        // TC: O(N), SC: O(k)
        return optimal(s, k);
    }
}

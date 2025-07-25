class Solution {
    public boolean brute(String s, String t){
        int n1 = s.length();
        int n2 = t.length();

        if(n1 != n2) return false;

        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();

        for(char c: t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        for(char c: s.toCharArray()){
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }

        return sMap.equals(tMap);
    }

    public boolean optimal(String s, String t){
        int n1 = s.length();
        int n2 = t.length();

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(char c: s.toCharArray()){
            arr1[c - 97]++;
        }
        for(char c: t.toCharArray()){
            arr2[c - 97]++;
        }

        for(int i=0; i<26; i++){
            if(arr1[i] != arr2[i]) return false;
        }

        return true;
    }

    public boolean isAnagram(String s, String t) {
        // TC: O(S+T), SC: O(S+T)
        // return brute(s, t);

        // TC: O(S+T), SC: O(52) ~ O(1)
        return optimal(s, t);
    }
}

class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();

        HashMap<Character, Integer> firstOcc = new HashMap<>();
        HashMap<Character, Integer> lastOcc = new HashMap<>();

        for(int i=0; i<n; i++){
            char c = s.charAt(i);

            if(!firstOcc.containsKey(c)){
                firstOcc.put(c, i);
            }            
            lastOcc.put(c, i);
        }

        int count = 0;
        for(char c: firstOcc.keySet()){
            int first = firstOcc.get(c);
            int last = lastOcc.get(c);

            if(first == last) continue;

            HashSet<Character> set = new HashSet<>();
            for(int j=first+1; j<last; j++){
                set.add(s.charAt(j));
            }
            count += set.size();
        }

        return count;
    }
}
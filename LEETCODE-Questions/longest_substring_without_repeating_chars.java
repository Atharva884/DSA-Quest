class Solution {
    // Optimal Approach
    // TC: O(N), SC: O(N) in worst case
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();

        int sp = 0;
        int ep = 0;
        int ans = 0;
        while(ep < n){
            char next = s.charAt(ep);
            
            while(map.containsKey(s.charAt(ep))){
                map.remove(s.charAt(sp));
                sp++;
            }

            map.put(next, 1);
            ep++;
            ans = Math.max(ans, ep - sp);
        }

        return ans;
    }
}

class Solution {
    public int better(String s, int k){
        int n = s.length();
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        int sp = 0;
        int ep = 0;
        int max = -1;
        
        while(ep < n){
            // Acquire first
            char c = s.charAt(ep);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            while(map.size() > k){
                char old = s.charAt(sp);
                map.put(old, map.get(old) - 1);
                if(map.get(old) == 0) map.remove(old);
                
                sp++;
            }
            
            if(map.size() == k) max = Math.max(max, ep - sp + 1);
            ep++;
        }
        
        return max;
    }
    
    public int optimal(String s, int k){
        int n = s.length();
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        int sp = 0;
        int ep = 0;
        int max = -1;
        
        while(ep < n){
            // Acquire first
            char c = s.charAt(ep);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            if(map.size() > k){
                char old = s.charAt(sp);
                map.put(old, map.get(old) - 1);
                if(map.get(old) == 0) map.remove(old);
                
                sp++;
            }
            
            if(map.size() == k) max = Math.max(max, ep - sp + 1);
            ep++;
        }
        
        return max;
    }
    
    public int longestKSubstr(String s, int k) {
        // Brute Approach
        // TC: O(N^2), SC: O(1)
        return brute(s, k);
        
        // Better Approach
        // TC: O(N + N) ~ O(2N), SC: O(1)
        // return better(s, k);
        
        // Optimal Approach
        // TC: O(N), SC: O(1)
        // return optimal(s, k);
    }
}

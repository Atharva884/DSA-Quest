class Solution {
    // TC: O(2N) ~ O(N), SC: O(N)
    public String FirstNonRepeating(String s) {
        int n = s.length();
        
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        int i = 0;
        while(i < n){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            q.add(c);
            
            while (!q.isEmpty() && map.get(q.peek()) > 1) {
                q.remove();
            }
            
            sb.append(q.isEmpty() ? '#' : q.peek());
            i++;
        }
        
        return sb.toString();
    }
}

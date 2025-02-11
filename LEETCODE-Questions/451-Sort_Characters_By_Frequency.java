class Pair implements Comparable<Pair>{
    Character val;
    int cnt;

    public Pair(Character val, int cnt){
        this.val = val;
        this.cnt = cnt;
    }

    public int compareTo(Pair o){
        return o.cnt - this.cnt;
    }
}

class Solution {
    // TC: O(NlogN), SC: O(N)
    public String frequencySort(String s) {
        int n = s.length();

        HashMap<Character, Integer> lower = new HashMap<>();
        HashMap<Character, Integer> upper = new HashMap<>();

        for(int i=0; i<n; i++){
            char c = s.charAt(i);

            if(Character.isUpperCase(c)){
                upper.put(c, upper.getOrDefault(c, 0) + 1);
            }else{
                lower.put(c, lower.getOrDefault(c, 0) + 1);
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(Character key: lower.keySet()){
            int cnt = lower.get(key);
            if(cnt != 0){
                pq.add(new Pair(key, cnt));
            }
        }

        for(Character key: upper.keySet()){
            int cnt = upper.get(key);
            if(cnt != 0){
                pq.add(new Pair(key, cnt));
            }
        }
    
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int count = p.cnt;

            for(int i=0; i<count; i++){
                sb.append(p.val);
            } 
        }
        
        return sb.toString();
    }
}
class Pair implements Comparable<Pair>{
    int val;
    int cnt;

    public Pair(int val, int cnt){
        this.val = val;
        this.cnt = cnt;
    }

    public int compareTo(Pair o){
        return this.cnt - o.cnt;
    }
}

class Solution {
    // TC: O(Nlogk), SC: O(N + k)
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int key: map.keySet()){
            pq.add(new Pair(key, map.get(key)));
            if(pq.size() > k){
                pq.poll();
            }
        }   

        int[] ans = new int[k];
        
        int i = 0;
        while(!pq.isEmpty()){
            ans[i] = pq.poll().val;
            i++;
        }

        return ans;
    }
}
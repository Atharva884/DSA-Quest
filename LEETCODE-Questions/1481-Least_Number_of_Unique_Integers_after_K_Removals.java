class Pair implements Comparable<Pair>{
    int val;
    int occ;

    public Pair(int _val, int _occ){
        this.val = _val;
        this.occ = _occ;
    }

    public int compareTo(Pair o){
        return this.occ - o.occ;
    }
}

class Solution {
    // TC: O(NlogN), SC: O(2N)
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int key: map.keySet()){
            int val = map.get(key);

            pq.add(new Pair(key, val));
        }

        while (k != 0 && !pq.isEmpty()) {
            Pair rem = pq.peek();

            if(rem.occ == 1){
                pq.poll();
            }else{
                rem.occ--;
            }

            k--;
        }

        return pq.size();
    }
}
class Pair implements Comparable<Pair>{
    int val;
    int idx;

    public Pair(int _val, int _idx){
        this.val = _val;
        this.idx = _idx;
    }

    public int compareTo(Pair o){
        if(this.val == o.val){
            return this.idx - o.idx;
        }

        return this.val - o.val;
    }
}

class Solution {
    // TC: O(NlogN), SC: O(N)
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            pq.add(new Pair(nums[i], i));
        }

        while(k-- > 0){
            Pair rem = pq.poll();
            nums[rem.idx] = rem.val * multiplier;

            pq.add(new Pair(nums[rem.idx], rem.idx));
        }    

        return nums;
    }
}
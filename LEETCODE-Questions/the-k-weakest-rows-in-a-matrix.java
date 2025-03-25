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
    // TC: O(n*m + nlogk), SC: O(k)
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int idx=0; idx<n; idx++){
            int count = 0;
            for(int i=0; i<m; i++){
                count += mat[idx][i];
            }
            pq.add(new Pair(count, idx));

            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] ans = new int[k];
        int l = k-1;

        while(!pq.isEmpty()){
            ans[l--] = pq.poll().idx;
        }

        return ans;
    }
}

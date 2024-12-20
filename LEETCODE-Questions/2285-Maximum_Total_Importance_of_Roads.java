class Pair implements Comparable<Pair>{
    int u;
    int inDegree;

    public Pair(int _u, int _inDegree){
        this.u = _u;
        this.inDegree = _inDegree;
    }

    public int compareTo(Pair o){
        return o.inDegree - this.inDegree;
    }
}

class Solution {
    // TC: O(m + nlogn), SC: O(n)
    public long maximumImportance(int n, int[][] roads) {
        int m = roads.length;

        int[] inDegree = new int[n];

        for(int i=0; i<m; i++){
            int u = roads[i][0];
            int v = roads[i][1];
            inDegree[u]++;
            inDegree[v]++;
        }

        int[] ans = new int[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            pq.add(new Pair(i, inDegree[i]));
        }

        int k = n;
        while(!pq.isEmpty()){
            Pair rem = pq.poll();
            ans[rem.u] = k--;
        }

        long sum = 0;
        for(int i=0; i<m; i++){
            int u = roads[i][0];
            int v = roads[i][1];

            sum += (ans[u] + ans[v]);
        }
        
        return sum;
    }
}

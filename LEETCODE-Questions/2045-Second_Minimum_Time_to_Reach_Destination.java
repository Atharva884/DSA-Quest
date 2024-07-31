class Solution {
    public static List<List<Integer>> graphConst(int[][] edges, int n){
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;
    }


    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> adj = graphConst(edges, n);

        // Why n+1? bcoz it is 1-based indexed
        int[] dist1 = new int[n+1];
        int[] dist2 = new int[n+1];
        for(int i=0; i<n+1; i++){
            dist1[i] = Integer.MAX_VALUE; 
            dist2[i] = Integer.MAX_VALUE; 
        }

        // As distance to travel node 1 to 1 is 0
        dist1[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{1, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.remove();

            int node = cur[0];
            int dist = cur[1];

            // We have got the second minimum value to reach dest i.e n
            if(node == n && dist2[n] != Integer.MAX_VALUE){
                return dist2[n];
            }

            // If the curr node has the red signal then we need to wait till it
            // become green
            if((dist/change) % 2 == 1){
                // If it is odd, then wait till it become signal
                dist += change - (dist % change);
            }

            // Time to travel one node to another
            dist += time;

            // If not, explore the nbrs
            List<Integer> nbrs = adj.get(node);
            for(int nbr: nbrs){
                if(dist < dist1[nbr]){
                    dist2[nbr] = dist1[nbr];
                    dist1[nbr] = dist;
                    pq.add(new int[]{ nbr, dist });
                }else if(dist > dist1[nbr] && dist < dist2[nbr]){
                    dist2[nbr] = dist;
                    pq.add(new int[]{ nbr, dist });
                }

            }
        }

        return -1;
    }
}
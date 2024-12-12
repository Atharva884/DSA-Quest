class Pair implements Comparable<Pair> {
    int vtx;
    long weight;

    public Pair(int _vtx, long _weight) {
        this.vtx = _vtx;
        this.weight = _weight;
    }

    public int compareTo(Pair o) {
        return Long.compare(this.weight, o.weight);
    }
}

class Solution {
    long mod = (long) (1e9 + 7);
    public ArrayList<ArrayList<Pair>> construction(int[][] edges, int n, int m) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }

        return graph;
    }

    // TC: O(ElogV), SC: O(V)
    public int countPaths(int n, int[][] roads) {
        int m = roads.length;

        ArrayList<ArrayList<Pair>> graph = construction(roads, n, m);

        long[] dist = new long[n];
        long[] ways = new long[n];

        for(int i=0; i<n; i++){
            dist[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }

        dist[0] = 0;
        ways[0] = 1;  // Initially src has been visited by 1 path only

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair rem = pq.poll();
            int vtx = rem.vtx;
            long weight = rem.weight;

            for (Pair nbr : graph.get(vtx)) {
                int v = nbr.vtx;
                long w = nbr.weight;

                // You have encountered first time
                if(weight + w < dist[v]){
                    dist[v] = weight + w;
                    pq.add(new Pair(v, weight + w));
                    ways[v] = ways[vtx];
                }else if(weight + w == dist[v]){
                    // You are coming again with the same distance but
                    // with the different path
                    ways[v] = (ways[v] + ways[vtx]) % mod;
                }
            }
        }

        return (int) (ways[n-1] % mod);
    }
}
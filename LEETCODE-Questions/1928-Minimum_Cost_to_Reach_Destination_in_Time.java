class Tuple implements Comparable<Tuple> {
    int vtx;
    int time;
    int fee;

    public Tuple(int _vtx, int _time, int _fee) {
        this.vtx = _vtx;
        this.time = _time;
        this.fee = _fee;
    }

    public int compareTo(Tuple o) {
        return this.fee - o.fee;
    }
}

class Solution {
    public ArrayList<ArrayList<Tuple>> construction(int[][] edges, int[] fees, int n, int m) {
        ArrayList<ArrayList<Tuple>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int k = 0;
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int t = edges[i][2];

            graph.get(u).add(new Tuple(v, t, 0));
            graph.get(v).add(new Tuple(u, t, 0));
        }

        return graph;
    }

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        int m = edges.length;

        ArrayList<ArrayList<Tuple>> graph = construction(edges, passingFees, n, m);

        // {fee, time}
        int[][] dist = new int[n][maxTime + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][0] = passingFees[0];

        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        pq.add(new Tuple(0, 0, passingFees[0]));

        while (!pq.isEmpty()) {
            Tuple rem = pq.poll();
            int vtx = rem.vtx;
            int time = rem.time;
            int fee = rem.fee;

            if (time > maxTime) {
                continue;
            }
            
            // If it has reached the target within the maxTime the for sure
            // it will be the least fee among various paths
            if (vtx == n - 1) {
                return fee;
            }

            ArrayList<Tuple> nbrs = graph.get(vtx);
            for (Tuple nbr : nbrs) {
                int newTime = time + nbr.time;
                int newFee = fee + passingFees[nbr.vtx];

                if (newTime <= maxTime && newFee < dist[nbr.vtx][newTime]) {
                    dist[nbr.vtx][newTime] = newFee;
                    pq.add(new Tuple(nbr.vtx, newTime, newFee));
                }
            }
        }

        return -1;
    }
}
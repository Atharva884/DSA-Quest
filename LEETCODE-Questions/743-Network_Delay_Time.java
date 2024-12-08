class Pair implements Comparable<Pair>{
    int vtx;
    int weight;

    public Pair(int _vtx, int _weight) {
        this.vtx = _vtx;
        this.weight = _weight;
    }

    public int compareTo(Pair o) {
        return this.weight - o.weight;
    }
}

class Solution {

    public ArrayList<ArrayList<Pair>> construction(int[][] times, int n, int m) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            // Directed graph
            graph.get(u).add(new Pair(v, w));
        }

        return graph;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int m = times.length;
        ArrayList<ArrayList<Pair>> graph = construction(times, n, m);

        int[] ans = new int[n + 1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k, 0));

        while (!pq.isEmpty()) {
            Pair rem = pq.poll();
            int vtx = rem.vtx;
            int weight = rem.weight;

            if (ans[vtx] != Integer.MAX_VALUE)
                continue;
            ans[vtx] = weight;

            ArrayList<Pair> nbrs = graph.get(vtx);
            for (Pair nbr : nbrs) {
                int v = nbr.vtx;
                int w = nbr.weight;

                if (ans[v] != Integer.MAX_VALUE)
                    continue;
                pq.add(new Pair(v, weight + w));
            }
        }

        // Check if any nodes is unvisited
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, ans[i]);
        }

        return max;
    }
}
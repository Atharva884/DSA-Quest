// class Pair implements Comparable<Pair> {
//     int vtx;
//     int weight;
//     int stops;

//     public Pair(int _vtx, int _weight, int _stops) {
//         this.vtx = _vtx;
//         this.weight = _weight;
//         this.stops = _stops;
//     }

//     public int compareTo(Pair o) {
//         return this.weight - o.weight; // Min-Heap based on weight
//     }
// }

// class Pair1 {
//     int vtx;
//     int weight;

//     public Pair1(int _vtx, int _weight) {
//         this.vtx = _vtx;
//         this.weight = _weight;
//     }
// }

// Brute Force - { TLE }
// TC: O(VlogE), SC: O(E)
// class Solution {
//     public ArrayList<ArrayList<Pair1>> construction(int[][] edges, int n, int m) {
//         ArrayList<ArrayList<Pair1>> graph = new ArrayList<>();

//         for (int i = 0; i < n; i++) {
//             graph.add(new ArrayList<>());
//         }

//         for (int i = 0; i < m; i++) {
//             int u = edges[i][0];
//             int v = edges[i][1];
//             int w = edges[i][2];

//             graph.get(u).add(new Pair1(v, w));
//         }

//         return graph;
//     }

//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         int m = flights.length;
//         ArrayList<ArrayList<Pair1>> graph = construction(flights, n, m);

//         PriorityQueue<Pair> pq = new PriorityQueue<>();
//         pq.add(new Pair(src, 0, 0));

//         while (!pq.isEmpty()) {
//             Pair rem = pq.poll();
//             int vtx = rem.vtx;
//             int weight = rem.weight;
//             int stops = rem.stops;

//             if (vtx == dst) {
//                 return weight;
//             }

//             if (stops <= k) {
//                 for (Pair1 nbr : graph.get(vtx)) {
//                     pq.add(new Pair(nbr.vtx, weight + nbr.weight, stops + 1));
//                 }
//             }
//         }

//         return -1;
//     }
// }

class Pair{
    int vtx;
    int weight;

    public Pair(int _vtx, int _weight){
        this.vtx = _vtx;
        this.weight = _weight;
    }
}

class Tuple{
    int stops;
    int vtx;
    int dist;

    public Tuple(int _stops, int _vtx, int _dist){
        this.stops = _stops;
        this.vtx = _vtx;
        this.dist = _dist;
    }
}

class Solution{
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
        }

        return graph;
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int m = flights.length;
        ArrayList<ArrayList<Pair>> graph = construction(flights, n, m);

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));

        while(!q.isEmpty()){
            Tuple rem = q.poll();
            int stops = rem.stops;
            int vtx = rem.vtx;
            int w = rem.dist;

            if(stops > k) continue;

            ArrayList<Pair> nbrs = graph.get(vtx);
            for(Pair nbr : nbrs){
                int v = nbr.vtx;
                int weight = nbr.weight;

                if(w + weight < dist[v]){
                    dist[v] = w + weight;
                    q.add(new Tuple(stops + 1, v, w + weight));
                }
            }
        }


        if(dist[dst] == Integer.MAX_VALUE){
            return -1;
        }

        return dist[dst];
    }
}
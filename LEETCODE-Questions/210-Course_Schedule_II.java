class Solution {
    public static ArrayList<ArrayList<Integer>> construction(int[][] edges, int V, int m, int[] inDeg){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0; i<V; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            graph.get(u).add(v);
            inDeg[v]++;
        }

        return graph;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int m = prerequisites.length;
        int n = numCourses;

        int[] inDeg = new int[n];
        int[] ans = new int[n];

        ArrayList<ArrayList<Integer>> graph = construction(prerequisites, n, m, inDeg);
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            if(inDeg[i] == 0){
                q.add(i);
            }
        }

        int i = n-1;
        int count = 0;
        while(q.size() != 0){
            int rem = q.poll();
                
            if(i >= 0){
                ans[i] = rem;
                i--;
            }

            count++;

            ArrayList<Integer> nbrs = graph.get(rem);
            for(int nbr: nbrs){
                inDeg[nbr]--;

                if(inDeg[nbr] == 0){
                    q.add(nbr);
                }
            }
        }

        if(count != n){
            return new int[0];
        }

        return ans;
    }
}
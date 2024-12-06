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

    // TC: O(N+M), SC: O(N+M)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int m = prerequisites.length;

        int[] inDeg = new int[numCourses];
        
        ArrayList<ArrayList<Integer>> graph = construction(prerequisites, numCourses, m, inDeg);
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<inDeg.length; i++){
            if(inDeg[i] == 0){
                q.add(i);
            }
        }
        
        int count = 0;
        while(q.size() != 0){
            int rem = q.poll();
            
            count++;
            
            ArrayList<Integer> nbrs = graph.get(rem);
            for(int nbr: nbrs){
                inDeg[nbr]--;
                
                if(inDeg[nbr] == 0){
                    q.add(nbr);
                }
            }
        }
        
        return count == numCourses;
    }
}
class Solution {
    public ArrayList<ArrayList<Integer>> construction(int[][] edges, int n, int m, int[] inDegree){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        // Making reverse graph for the topo sort using indegree
        for(int i=0; i<n; i++){
            for(int nbr: edges[i]){
                graph.get(nbr).add(i);
                inDegree[i]++;
            }
        }

        return graph;
    }

    public List<Integer> eventualSafeNodes(int[][] edges) {
        int n = edges.length;
        int m = edges[0].length;

        int[] inDegree = new int[n];
        List<Integer> ans = new ArrayList<>();

        ArrayList<ArrayList<Integer>> graph = construction(edges, n, m, inDegree);

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int vtx = q.poll();

            ans.add(vtx);

            for(int nbr: graph.get(vtx)){
                inDegree[nbr]--;

                if(inDegree[nbr] == 0){
                    q.add(nbr);
                }
            }
        }

        Collections.sort(ans);

        return ans;
    }
}
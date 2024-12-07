/*
class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
*/

// User function Template for Java
class Solution {
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> graph, int src) {
        int n = graph.size();
        int[] ans = new int[n];
        
        Arrays.fill(ans, Integer.MAX_VALUE);
        
        PriorityQueue<iPair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.second, b.second));
        pq.add(new iPair(src, 0));
        
        while(pq.size() != 0){
            iPair rem = pq.poll();
            
            int vtx = rem.first;
            int w = rem.second;
            
            if(ans[vtx] != Integer.MAX_VALUE){
                continue;
            }
            
            ans[vtx] = w;
            
            for(iPair nbr: graph.get(vtx)){
                int nVtx = nbr.first;
                int nWeight = nbr.second;
                
                // Those who have burned already
                if(ans[nVtx] != Integer.MAX_VALUE){
                    continue;
                }
                
                pq.add(new iPair(nVtx, w + nWeight));
            }
        }
        
        ArrayList<Integer> finalAns = new ArrayList<>();
        for(int num: ans){
            finalAns.add(num);
        }
        
        return finalAns;
    }
}
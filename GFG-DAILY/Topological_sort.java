class Solution {
    
    static int[] getInDegree(ArrayList<ArrayList<Integer>> graph){
        int n = graph.size();
        
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++){
            ArrayList<Integer> nbrs = graph.get(i);
            
            for(int nbr: nbrs){
                arr[nbr]++;
            }
        }
        
        return arr;
    }
    
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> graph) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        int[] inDeg = getInDegree(graph);
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<inDeg.length; i++){
            if(inDeg[i] == 0){
                q.add(i);
            }
        }
        
        while(q.size() != 0){
            int rem = q.poll();
            
            ans.add(rem);
            
            ArrayList<Integer> nbrs = graph.get(rem);
            for(int nbr: nbrs){
                inDeg[nbr]--;
                
                if(inDeg[nbr] == 0){
                    q.add(nbr);
                }
            }
        }
        
        
        return ans;
    }
}
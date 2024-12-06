/*Complete the function below*/

class Solution {
    
    static int[] getInDegree(ArrayList<ArrayList<Integer>> graph, int V){
        int[] arr = new int[V];
        
        for(int i=0; i<V; i++){
            ArrayList<Integer> nbrs = graph.get(i);
            
            for(int nbr: nbrs){
                arr[nbr]++;
            }
        }
        
        return arr;
    }
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> graph) {
        int[] inDeg = getInDegree(graph, V);
        
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
        
        return count != V;
    }
}
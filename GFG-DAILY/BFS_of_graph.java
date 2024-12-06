// User function Template for Java
class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
       
        
        while(q.size() != 0){
            int rem = q.poll();
            
            if(!vis[rem]){
                ans.add(rem);
            }
            
            vis[rem] = true;
            
            // Get the neighbors and add into queue
            ArrayList<Integer> nbrs = adj.get(rem);
            for(int nbr: nbrs){
                if(!vis[nbr]){
                    q.add(nbr);
                }
            }
        }
        
        return ans;
    }
}
class Solution
{
    boolean[] vis;
    int[] disc;
    int[] low;
    boolean[] ans;
    int time = 0;
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int n,ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> result = new ArrayList<>();
        vis = new boolean[n];
        disc = new int[n];
        low = new int[n];
        ans = new boolean[n];
       
        bridges(adj , n ,0, -1); 
       
        for(int i = 0; i<n; i++){
            if(ans[i] == true){
                result.add(i);
            }
        }
       
        if(result.size() == 0) result.add(-1);
       
        return result;
    }
    public void bridges(ArrayList<ArrayList<Integer>> graph , int n ,int src , int par){
        disc[src] = time;
        low[src] = time;
        vis[src] = true;
        
        time++;
        int count = 0; // for check how many calls from actual source
        List<Integer> nbrs = graph.get(src);
        for(int nbr : nbrs){
            if(nbr == par) continue;
            else if(vis[nbr] == false) {                                                                           
                count++;
                
                bridges(graph , n , nbr , src);
                low[src] = Math.min(low[src] , low[nbr]);
                if(par == -1){
                    // System.out.println(count);
                  if(count >= 2){
                      ans[src] = true;
                  }
                } else {
                  if(low[nbr] >= disc[src]){
                     ans[src] = true;
                  }
                }
                
            } else {
                low[src] = Math.min(low[src] , disc[nbr]);
            }
        }
        
    }
}

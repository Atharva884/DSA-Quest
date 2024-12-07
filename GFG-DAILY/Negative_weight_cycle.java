//User function Template for Java

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges){
        int[] ans = new int[n];
        int m = edges.length;
        
        
        for(int src=0; src<n; src++){
            Arrays.fill(ans, Integer.MAX_VALUE);
            ans[src] = 0;
            
            
            for(int i=0; i<n-1; i++){
                for(int j=0; j<m; j++){
                    int u = edges[j][0];
                    int v = edges[j][1];
                    int w = edges[j][2];
                    
                    if(ans[u] != Integer.MAX_VALUE && ans[u] + w < ans[v]){
                        ans[v] = ans[u] + w;
                    }
                }
            }
            

            for(int j=0; j<m; j++){
                int u = edges[j][0];
                int v = edges[j][1];
                int w = edges[j][2];
                
                if(ans[u] != Integer.MAX_VALUE && ans[u] + w < ans[v]){
                    return 1;
                }
            }
        }
        
        
        return 0;
    }
}
// User function Template for Java

class Tuple{
    int i;
    int j;
    int w;
    
    public Tuple(int _i, int _j, int _w){
        this.i = _i;
        this.j = _j;
        this.w = _w;
    }
}

class Solution {

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; 
    // TC: O(V+E), SC: O(V)
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(source[0], source[1], 0));
        vis[source[0]][source[1]] = true;
        
        // int min = Integer.MAX_VALUE;
        
        while(!q.isEmpty()){
            Tuple rem = q.poll();
            int i = rem.i;
            int j = rem.j;
            int w = rem.w;
            
            // Reached the destination
            if(i == destination[0] && j == destination[1]){
                return w;
            }
            
            
            // Explore the nbrs
            for(int d=0; d<4; d++){
                int iDash = i + dirs[d][0];
                int jDash = j + dirs[d][1];
                
                if(iDash >= 0 && iDash < n && jDash >= 0 && jDash < m){
                    if(grid[iDash][jDash] == 1 && !vis[iDash][jDash]){
                        vis[iDash][jDash] = true;
                        q.add(new Tuple(iDash, jDash, w + 1));
                    }
                }
            }
        }
        
        return -1;
    }
}

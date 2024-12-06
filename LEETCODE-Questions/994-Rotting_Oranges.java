class Pair{
    int i;
    int j;
    int t;

    public Pair(int _i, int _j, int _t){
        this.i = _i;
        this.j = _j;
        this.t = _t;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        // Find the rotting oranges for min 0
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                }
            }
        }

        int ans = 0;
        while(q.size() != 0){
            Pair rem = q.poll();
            int i = rem.i;
            int j = rem.j;
            int t = rem.t;

            ans = t;
            
            // Check the four direction
            // Top Dir
            if(i-1 >= 0 && grid[i-1][j] == 1){
                grid[i-1][j] = 2;
                q.add(new Pair(i-1, j, t + 1));
            }

            // Right Dir
            if(j+1 < m && grid[i][j+1] == 1){
                grid[i][j+1] = 2;
                q.add(new Pair(i, j+1, t + 1));
            }

            // Bottom Dir
            if(i+1 < n && grid[i+1][j] == 1){
                grid[i+1][j] = 2;
                q.add(new Pair(i+1, j, t + 1));
            }

            // Left Dir
            if(j-1 >= 0 && grid[i][j-1] == 1){
                grid[i][j-1] = 2;
                q.add(new Pair(i, j-1, t + 1));
            }
        }

        // Check it any oranges have been not rotted
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return ans;
    }
}
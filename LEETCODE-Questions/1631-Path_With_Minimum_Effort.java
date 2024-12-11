class Tuple implements Comparable<Tuple>{
    int i;
    int j;
    int w;

    public Tuple(int _i, int _j, int _w){
        this.i = _i;
        this.j = _j;
        this.w = _w;
    }

    public int compareTo(Tuple o){
        return this.w - o.w;
    }
}

class Solution {
    // Dirs
    int[][] dirs = {{-1,0}, {0, 1}, {1, 0}, {0, -1}};
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] vis = new boolean[n][m];
        vis[0][0] = true;

        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        pq.add(new Tuple(0, 0, 0));

        while(!pq.isEmpty()){
            Tuple rem = pq.poll();
            int i = rem.i;
            int j = rem.j;
            int w = rem.w;

            if(i == n-1 && j == m-1){
                return w;
            }

            vis[i][j] = true;

            for(int d=0; d<4; d++){
                int iDash = i + dirs[d][0];
                int yDash = j + dirs[d][1];

                if(iDash >= 0 && iDash < n && yDash >= 0 && yDash < m){
                    if(!vis[iDash][yDash]){
                        int effort = Math.abs(heights[iDash][yDash] - heights[i][j]);
                        int maxEffort = Math.max(w, effort);

                        pq.add(new Tuple(iDash, yDash, maxEffort));
                    }
                }
            }
        }

        return -1;
    }
}
class Tuple {
    int i;
    int j;
    int w;

    public Tuple(int _i, int _j, int _w) {
        this.i = _i;
        this.j = _j;
        this.w = _w;
    }
}

class Solution {
    int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 } };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        Queue<Tuple> q = new LinkedList<>();
        if (grid[0][0] == 1) {
            return -1;
        }
        q.add(new Tuple(0, 0, 1));
        vis[0][0] = true;

        while (!q.isEmpty()) {
            Tuple rem = q.poll();
            int i = rem.i;
            int j = rem.j;
            int w = rem.w;

            // Reached the destination
            if (i == n - 1 && j == m - 1) {
                return w;
            }

            // Explore the nbrs
            for (int d = 0; d < 8; d++) {
                int iDash = i + dirs[d][0];
                int jDash = j + dirs[d][1];

                if (iDash >= 0 && iDash < n && jDash >= 0 && jDash < m) {
                    if (grid[iDash][jDash] == 0 && !vis[iDash][jDash]) {
                        vis[iDash][jDash] = true;
                        q.add(new Tuple(iDash, jDash, w + 1));
                    }
                }
            }
        }

        return -1;
    }
}
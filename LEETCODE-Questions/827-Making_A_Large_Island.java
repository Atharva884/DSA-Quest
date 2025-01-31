class DisjointSet {
    int[] par;
    int[] rank;
    int[] size;

    public DisjointSet(int n) {
        par = new int[n];
        rank = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 1;
            size[i] = 1;
        }
    }

    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py)
            return false;

        if (rank[px] > rank[py]) {
            par[py] = px;
            size[px] += size[py];
        } else if (rank[px] < rank[py]) {
            par[px] = py;
            size[py] += size[px];
        } else {
            par[px] = py;
            size[py] += size[px];
            rank[py]++;
        }

        return true;
    }

    public int find(int x) {
        if (par[x] == x)
            return x;

        int temp = find(par[x]);
        par[x] = temp;

        return temp;
    }
}

class Solution {
    int[][] dirs = { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } };

    public boolean checkBounds(int i, int j, int n) {
        return (i >= 0 && i < n && j >= 0 && j < n);
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;

        DisjointSet ds = new DisjointSet(n * n);

        // Step 1) Find the size of each connected comp in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    
                    for (int d = 0; d < 4; d++) {
                        int iDash = i + dirs[d][0];
                        int jDash = j + dirs[d][1];

                        if (checkBounds(iDash, jDash, n) && grid[iDash][jDash] == 1) {
                            int u = (i * n) + j;
                            int v = (iDash * n) + jDash;

                            ds.union(u, v);
                        }
                    }

                }
            }
        }

        // Step 2) Covert 0 to 1 and check for the nbrs and get the max
        int max = -1;
        for (int i = 0; i < n * n; i++) {
            max = Math.max(max, ds.size[i]);
        }

       

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    // To check for unique components
                    HashSet<Integer> hs = new HashSet<>();

                    for (int d = 0; d < 4; d++) {
                        int iDash = i + dirs[d][0];
                        int jDash = j + dirs[d][1];

                        if (checkBounds(iDash, jDash, n) && grid[iDash][jDash] == 1) {
                            int cellNo = (iDash * n) + jDash;
                            int root = ds.find(cellNo);
                            hs.add(root);
                        }
                    }

                    // 1 for current
                    int sum = 1;
                    for (int num : hs) {
                        sum += ds.size[num];
                    }

                    // Get the max
                    max = Math.max(max, sum);
                }
            }
        }

        return max;
    }
}

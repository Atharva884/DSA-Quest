class Solution {
    public void dfs(int i, int j, int n, int m, int[][] grid, boolean[][] arr) {
        arr[i][j] = true;

        // Top Dir
        if (i - 1 >= 0 && grid[i - 1][j] == 1 && !arr[i - 1][j]) {
            dfs(i - 1, j, n, m, grid, arr);
        }

        // Right Dir
        if (j + 1 < m && grid[i][j + 1] == 1 && !arr[i][j + 1]) {
            dfs(i, j + 1, n, m, grid, arr);
        }

        // Bottom Dir
        if (i + 1 < n && grid[i + 1][j] == 1 && !arr[i + 1][j]) {
            dfs(i + 1, j, n, m, grid, arr);
        }

        // Left Dir
        if (j - 1 >= 0 && grid[i][j - 1] == 1 && !arr[i][j - 1]) {
            dfs(i, j - 1, n, m, grid, arr);
        }
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] arr = new boolean[n][m];

        // Check the first row for any 0's
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1) {
                dfs(0, i, n, m, grid, arr);
            }
        }

        // Check the first col for any 0's
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                dfs(i, 0, n, m, grid, arr);
            }
        }

        // Check the last row for any 0's
        for (int i = 0; i < m; i++) {
            if (grid[n - 1][i] == 1) {
                dfs(n - 1, i, n, m, grid, arr);
            }
        }

        // Check the last col for any 0's
        for (int i = 0; i < n; i++) {
            if (grid[i][m - 1] == 1) {
                dfs(i, m - 1, n, m, grid, arr);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == true) {
                    grid[i][j] = 0;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += grid[i][j];
            }
        }

        return ans;
    }
}
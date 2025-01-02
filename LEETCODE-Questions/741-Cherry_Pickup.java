class Solution {
    // TC: O(N^2 * M), SC: O(N^2 * M)
    public int solve(int row1, int col1, int row2, int[][] grid, int n, int m, int[][][] dp) {
        int col2 = row1 + col1 - row2;

        if (row1 >= n || row2 >= n || col1 >= m || col2 >= m || grid[row1][col1] == -1 || grid[row2][col2] == -1)
            return Integer.MIN_VALUE;

        if (row1 == n - 1 && row2 == n - 1 && col1 == m - 1 && col2 == m - 1) {
            return grid[row1][col1];
        }

        if (dp[row1][col1][row2] != -1) {
            return dp[row1][col1][row2];
        }

        int rr = solve(row1, col1 + 1, row2, grid, n, m, dp);
        int rd = solve(row1, col1 + 1, row2 + 1, grid, n, m, dp);
        int dr = solve(row1 + 1, col1, row2, grid, n, m, dp);
        int dd = solve(row1 + 1, col1, row2 + 1, grid, n, m, dp);

        int ans = Math.max(Math.max(rr, rd), Math.max(dr, dd));

        int contri = 0;

        // Check if the two person are on same box then pick the cherry only
        // once
        if (row1 == row2 && col1 == col2) {
            contri = grid[row1][col1];
        } else {
            contri = grid[row1][col1] + grid[row2][col2];
        }

        if (ans == Integer.MIN_VALUE) {
            dp[row1][col1][row2] = Integer.MIN_VALUE;
            return Integer.MIN_VALUE;
        } else {
            dp[row1][col1][row2] = ans + contri;
            return ans + contri;
        }
    }

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][n];
        for (int[][] outer1 : dp) {
            for (int[] outer2 : outer1) {
                Arrays.fill(outer2, -1);
            }
        }

        int ans = solve(0, 0, 0, grid, n, m, dp);

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}
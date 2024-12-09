class Solution {
    public void dfs(int i, int j, int n, int m, char[][] board, boolean[][] arr) {
        arr[i][j] = true;

        // Top Dir
        if (i - 1 >= 0 && board[i - 1][j] == 'O' && !arr[i-1][j]) {
            dfs(i - 1, j, n, m, board, arr);
        }

        // Right Dir
        if (j + 1 < m && board[i][j + 1] == 'O' && !arr[i][j+1]) {
            dfs(i, j + 1, n, m, board, arr);
        }

        // Bottom Dir
        if (i + 1 < n && board[i + 1][j] == 'O' && !arr[i+1][j]) {
            dfs(i + 1, j, n, m, board, arr);
        }

        // Left Dir
        if (j - 1 >= 0 && board[i][j - 1] == 'O' && !arr[i][j-1]) {
            dfs(i, j - 1, n, m, board, arr);
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] arr = new boolean[n][m];

        // Check the first row for any 0's
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') {
                dfs(0, i, n, m, board, arr);
            }
        }

        // Check the first col for any 0's
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, n, m, board, arr);
            }
        }

        // Check the last row for any 0's
        for (int i = 0; i < m; i++) {
            if (board[n - 1][i] == 'O') {
                dfs(n - 1, i, n, m, board, arr);
            }
        }

        // Check the last col for any 0's
        for (int i = 0; i < n; i++) {
            if (board[i][m - 1] == 'O') {
                dfs(i, m - 1, n, m, board, arr);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == false){
                    board[i][j] = 'X';
                }else{
                    board[i][j] = 'O';
                }
            }
        }


    }
}
class Solution {
    public boolean isValid(int i, int j, char c, char[][] board){
        // Check the entire row
        for(int idx=0; idx<9; idx++){
            if(board[i][idx] != '.' && board[i][idx] == c){
                return false;
            }
        }

        // Check the entire col
        for(int idx=0; idx<9; idx++){
            if(board[idx][j] != '.' && board[idx][j] == c){
                return false;
            }
        }

        // Check the entire row
        int x = 3 * (i / 3);
        int y = 3 * (j / 3);

        for(int m=0; m<=2; m++){
            for(int n=0; n<=2; n++){
                if(board[x + m][y + n] != '.' && board[x + m][y + n] == c) return false;
            }
        }

        return true;
    }

    // TC: O(N ^ N*N) but input size is fixed so, O(9 ^ 81), SC: O(N ^ N*N) ~ O(1)
    public boolean solve(char[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(i, j, c, board)) {
                            board[i][j] = c;
                            boolean flag = solve(board, n);
                            if (flag == true)
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    public void solveSudoku(char[][] board) {
        int n = board.length;

        solve(board, n);
    }
}

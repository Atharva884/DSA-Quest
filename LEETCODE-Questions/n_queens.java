class Solution {
    public boolean isValid(int i, int j, int n, int[][] board){
        // Check Col
        for(int idx=0; idx<n; idx++){
            if(board[idx][j] == 1) return false;
        }

        // Top left column
        int x = i;
        int y = j;
        while(x >= 0 && y >= 0){
            if(board[x][y] == 1) return false;

            x--;
            y--;
        }

        // Top right column
        x = i;
        y = j;
        while(x >= 0 && y < n){
            if(board[x][y] == 1) return false;

            x--;
            y++;
        }

        return true;
    }

    public void solve(int i, int[][] board, int n, List<List<String>> ans){
        if(i == n){
            List<String> temp = new ArrayList<>();
            for(int[] a: board){
                StringBuilder sb = new StringBuilder();
                for(int num: a){
                    if(num == 0){
                        sb.append('.');
                    }else{
                        sb.append('Q');
                    }
                }
                temp.add(sb.toString());
            }

            ans.add(temp);
        }

        for(int j=0; j<n; j++){
            if(isValid(i, j, n, board)){
                board[i][j] = 1;
                solve(i+1, board, n, ans);
                board[i][j] = 0;
            }
        }
    }

    // Optimal Approach
    // TC: O(N^N * N), SC: O(N^N) - Excluded the result list
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[][] board = new int[n][n];

        solve(0, board, n, ans);

        return ans;
    }
}

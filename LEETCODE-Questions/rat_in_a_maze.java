class Solution {
    public void solve(int[][] maze, int i, int j, int n, StringBuilder sb, ArrayList<String> ans){
        if(i == n-1 && j == n-1){
            ans.add(sb.toString());
            return;
        }
        
        maze[i][j] = 2;
        
        // Top Direction
        if(i-1 >= 0 && maze[i-1][j] != 2 && maze[i-1][j] != 0){
            sb.append('U');
            solve(maze, i-1, j, n, sb, ans);
            sb.setLength(sb.length() - 1);
        }
        
        // Down Direction
        if(i+1 < n && maze[i+1][j] != 2 && maze[i+1][j] != 0){
            sb.append('D');
            solve(maze, i+1, j, n, sb, ans);
            sb.setLength(sb.length() - 1);
        }
        
        // Right Direction
        if(j+1 < n && maze[i][j+1] != 2 && maze[i][j+1] != 0){
            sb.append('R');
            solve(maze, i, j+1, n, sb, ans);
            sb.setLength(sb.length() - 1);
        }
        
        // Left Direction
        if(j-1 >= 0 && maze[i][j-1] != 2 && maze[i][j-1] != 0){
            sb.append('L');
            solve(maze, i, j-1, n, sb, ans);
            sb.setLength(sb.length() - 1);
        }
        
        maze[i][j] = 1;
    }
    
    // Backtracking Approach
    // TC: O(4 ^ (N*N)), SC: O(N^2)
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int n = maze.length;
        
        solve(maze, 0, 0, n, sb, ans);
        
        Collections.sort(ans);
        
        return ans;
    }
}

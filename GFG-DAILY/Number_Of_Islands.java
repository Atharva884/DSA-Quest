//User function Template for Java
 
class Solution {
    int count = 0;
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    // Find By Union
    public void union(int x, int y, int[] par, int[] rank){
        int px = find(x, par);
        int py = find(y, par);

        // They are already in the same grp
        if(px == py){
            return;
        }

        if(rank[px] > rank[py]){
            par[py] = px;
        }else if(rank[px] < rank[py]){
            par[px] = py;
        }else{
            // They are of same size
            par[px] = py;
            rank[py]++;
        }
        
        count--;
    }

    // Find
    public int find(int x, int[] par){
        if(x == par[x]){
            return par[x];
        }

        int temp = find(par[x], par);
        par[x] = temp;

        return temp;
    }
    
    // TC: O(N^2), SC: O(N*M)
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        int k = operators.length;
        
        int[][] arr = new int[rows][cols];
        List<Integer> ans = new ArrayList<>();
        
        int[] par = new int[rows * cols];
        int[] rank = new int[rows * cols];
        
        for(int i=0; i<rows * cols; i++){
            par[i] = -1;
            rank[i] = 1;
        }
        
        for(int l=0; l<k; l++){
            int i = operators[l][0];
            int j = operators[l][1];
            
            int cellNo = (i * cols) + j;
            
            if (arr[i][j] == 1) {
                ans.add(count);
                continue;
            }
            
            // Mark it as 1
            arr[i][j] = 1;
            count++;
            
            par[cellNo] = cellNo;
            
            // Check for the nbrs if they are 1's then it will form an island
            for(int d=0; d<4; d++){
                int xDash = i + dirs[d][0];
                int yDash = j + dirs[d][1];
                
                
                if(xDash >= 0 && xDash < rows && yDash >= 0 && yDash < cols){
                    int nbr = arr[xDash][yDash];
                    int c = (xDash * cols) + yDash; 
                    
                    if(nbr == 1){
                        union(cellNo, c, par, rank);
                    }
                }
                
            }
            
            ans.add(count);
        }
        
        
        return ans;    
    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}


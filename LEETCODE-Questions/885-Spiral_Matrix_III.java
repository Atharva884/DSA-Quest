class Solution {
    // TC: O(max(row, col) ^ 2), SC: O(1)
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int n = rows * cols;
        int[][] ans = new int[n][2]; // [[r,c], [r1,c1]...]

        // Creating directions array in the clockwise 
        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        ans[0][0] = rStart;
        ans[0][1] = cStart;

        // We initialize count by 1 becoz we need to stop after we have reached n and we have 
        // already inserted first row and col
        int count = 1; 
        int steps = 1;  // We will increment steps by one after 2 directions
        int index = 0;


        while(count < n){

            // Looping for the 2 directions and after this increment steps by 1
            for(int times=0; times<2; times++){
                int dr = dir[index%4][0];
                int dc = dir[index%4][1];

                for(int i=0; i<steps; i++){
                    rStart += dr;
                    cStart += dc;

                    if(rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols){
                        ans[count][0] = rStart;
                        ans[count][1] = cStart;
                        count++;
                    }
                }

                // After performing the direction as per the steps go to other directions
                index++;

            }

            steps++;
        }

        return ans;
    }
}
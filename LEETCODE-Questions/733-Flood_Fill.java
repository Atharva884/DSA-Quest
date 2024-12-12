class Solution {
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void dfs(int i, int j, int n, int m, int[][] img, int color, int startColor){
        img[i][j] = color;

        for(int d=0; d<4; d++){
            int iDash = i + dirs[d][0];
            int yDash = j + dirs[d][1];

            if(iDash >= 0 && iDash < n && yDash >= 0 && yDash < m){

                if(img[iDash][yDash] == startColor){
                    dfs(iDash, yDash, n, m, img, color, startColor);
                }

            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int startColor = image[sr][sc];

        if (startColor == color) return image;

        dfs(sr, sc, n, m, image, color, startColor);

        return image;
    }
}
class Solution {
    public static int solve(int i, int[][] books, int shelfWidth, int[] dp){
        // If there are no books left
        if(i >= books.length){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int width = 0;
        int maxHeight = 0;
        int ans = Integer.MAX_VALUE;

        for(int j=i; j<books.length; j++){
            width += books[j][0];
            if(width > shelfWidth){
                break;
            }
            maxHeight = Math.max(maxHeight, books[j][1]);
            ans = Math.min(maxHeight + solve(j+1, books, shelfWidth, dp), ans);
        }

        return dp[i] = ans;
    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[] dp = new int[books.length];
        Arrays.fill(dp, -1);

        return solve(0, books, shelfWidth, dp);
    }
}
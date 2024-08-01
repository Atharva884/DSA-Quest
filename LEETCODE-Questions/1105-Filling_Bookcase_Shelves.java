class Solution {
    // Iterative DP

    // public static int solve(int i, int[][] books, int shelfWidth, int[] dp){
    //     // If there are no books left
    //     if(i >= books.length){
    //         return 0;
    //     }

    //     if(dp[i] != -1){
    //         return dp[i];
    //     }

    //     int width = 0;
    //     int maxHeight = 0;
    //     int ans = Integer.MAX_VALUE;

    //     for(int j=i; j<books.length; j++){
    //         width += books[j][0];
    //         if(width > shelfWidth){
    //             break;
    //         }
    //         maxHeight = Math.max(maxHeight, books[j][1]);
    //         ans = Math.min(maxHeight + solve(j+1, books, shelfWidth, dp), ans);
    //     }

    //     return dp[i] = ans;
    // }

    // public int minHeightShelves(int[][] books, int shelfWidth) {
    //     int[] dp = new int[books.length];
    //     Arrays.fill(dp, -1);

    //     return solve(0, books, shelfWidth, dp);
    // }

    static int newShelfWidth;
    static int totalBooks;

    public static int solve(int bookIdx, int[][] books, int curSelfWidth, int curHeight, int[][] dp){
        // Get the max height for the current shelf
        int maxHeight = Math.max(curHeight, books[bookIdx][1]);

        // Base case
        // If it is a last book
        if(bookIdx == totalBooks-1){

            // Check if it accomodates in same shelf
            if(books[bookIdx][0] <= curSelfWidth){
                return maxHeight;
            }

            // If it not then accomodate in next shelf
            return curHeight + books[bookIdx][1];
        }

        // If it is already solved just return it
        if(dp[bookIdx][curSelfWidth] != 0){
            return dp[bookIdx][curSelfWidth];
        }

        // There is only 2 possibilities to keep the book in shelf

        // 1st Possibility
        // Keep in current or same shelf

        int sameShelf = Integer.MAX_VALUE;
        if(books[bookIdx][0] <= curSelfWidth){
            int updatedShelfWidth = curSelfWidth - books[bookIdx][0];
            int updatedShelfHeight = maxHeight;

            // Make sure u decrease the curSelfWidth after placing book
            sameShelf = solve(bookIdx+1, books, updatedShelfWidth, updatedShelfHeight, dp);
        }

        // 2nd Possibility
        // Keep in the next shelf
        int updatedShelfWidth = newShelfWidth - books[bookIdx][0];
        int updatedShelfHeight = books[bookIdx][1];

        int nextShelf = curHeight + solve(bookIdx+1, books, updatedShelfWidth, updatedShelfHeight, dp);

        return dp[bookIdx][curSelfWidth] = Math.min(sameShelf, nextShelf);
    }

    public int minHeightShelves(int[][] books, int shelfWidth){
        // Declared global variables
        newShelfWidth = shelfWidth; // 4
        totalBooks = books.length;
        int[][] dp = new int[totalBooks][newShelfWidth + 1];

        return solve(0, books, shelfWidth, 0, dp);
    }
}
class Solution {
    public int optimal(int[] heights){
        int n = heights.length;

        int i = 0;
        int j = n-1;
        int ans = 0;

        while(i < j){
            int width = j - i;
            int height = Math.min(heights[i], heights[j]);

            ans = Math.max(ans, width * height);

            if(heights[i] < heights[j]){
                i++;
            }else{
                j--;
            }
        }

        return ans;
    }

    public int brute(int[] heights){
        int n = heights.length;
        int ans = 0;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int width = j - i;
                int height = Math.min(heights[i], heights[j]);

                ans = Math.max(ans, width * height);
            }
        }

        return ans;
    }

    public int maxArea(int[] heights) {
        // Brute Approach - Brute Approach
        // TC: O(N^2), SC: O(1)
        // return brute(heights);

        // Optimal Approach
        // TC: O(N), SC: O(1)
        return optimal(heights);
    }
}

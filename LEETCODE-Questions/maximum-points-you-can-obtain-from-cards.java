class Solution {
    // Optimal Solution
    // TC: O(2k), SC: O(1)
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int lSum = 0;
        int rSum = 0;
        int max = 0;

        for(int i=0; i<k; i++){
            lSum += cardPoints[i];
        }

        max = Math.max(lSum, max);

        int rIdx = n-1;

        for(int i=k-1; i>=0; i--){
            lSum -= cardPoints[i];
            rSum += cardPoints[rIdx];
            rIdx--;

            max = Math.max(max, lSum + rSum);
        }

        return max;
    }
}

import java.util.*;

class Solution {
    public List<Integer> luckyNumbers(int[][] mat) {
        ArrayList<Integer> arr = new ArrayList<>();

        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {

            int min = Integer.MAX_VALUE;
            int idx = -1;

            for (int j = 0; j < m; j++) {
                if (mat[i][j] < min) {
                    min = mat[i][j];
                    idx = j;
                }
            }

            boolean isMax = true;
            for (int k = 0; k < n; k++) {
                if (mat[k][idx] > min) {
                    isMax = false;
                    break;
                }
            }

            if (isMax) {
                arr.add(min);
            }
        }

        return arr;
    }
}
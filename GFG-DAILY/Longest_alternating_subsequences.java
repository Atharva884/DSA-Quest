// User function Template for Java
//Back-end complete function Template for Java
class Solution {
    // TC: O(N), SC: O(1)
    public int alternatingMaxLength(int[] arr) {
        int n = arr.length;

        int count = 1;

        boolean cond1 = false;
        boolean cond2 = false;

        for (int i = 0; i < n - 1; i++) {

            // Check for both the testcases
            int cur = arr[i];
            int next = arr[i + 1];

            if ((cur < next && !cond1) || (cur < next && cond2)) {
                count++;
                cond1 = true;
                cond2 = false;
            }

            if ((cur > next && cond1) || (cur > next && !cond2)) {
                count++;
                cond1 = false;
                cond2 = true;
            }

            // if ((cur < next && !cond1) || (cur < next && cond2)) {
            // count++;
            // cond1 = true;
            // cond2 = false;
            // } else if ((cur > next && cond1) || (cur > next && !cond2)) {
            // count++;
            // cond1 = false;
            // cond2 = true;
            // }

        }

        return count;
    }
}
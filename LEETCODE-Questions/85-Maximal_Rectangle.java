class Solution {
    public static int[] NSEonRight(int[] arr, int n){
        int[] ans = new int[n];
        Arrays.fill(ans, n);
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
                int idx = st.pop();
                ans[idx] = i;
            }

            st.push(i);
        }

        return ans;
    }

    public static int[] NSEonLeft(int[] arr, int n){
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
                int idx = st.pop();
                ans[idx] = i;
            }

            st.push(i);
        }

        return ans;
    }

    public int histogram(int[] heights) {
        int n = heights.length;
        
        int[] nseOnRight = NSEonRight(heights, n);
        int[] nseOnLeft = NSEonLeft(heights, n);

        int ans = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            int height = heights[i];

            int x1 = nseOnRight[i] - 1;
            int x2 = nseOnLeft[i] + 1;
            int width = x1 - x2 + 1;

            int area = height * width;
            ans = Math.max(area, ans);
        }

        return ans;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int max = 0;
        int[] ans = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[j] = matrix[i][j] == '1' ? ans[j] + 1 : 0;
            }

            int area = histogram(ans);
            max = Math.max(area, max);
        }

        return max;
    }
}
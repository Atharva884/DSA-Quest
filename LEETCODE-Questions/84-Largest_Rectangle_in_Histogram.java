class Solution {
    // public static int[] NSEonRight(int[] arr, int n){
    //     int[] ans = new int[n];
    //     Arrays.fill(ans, n);
    //     Stack<Integer> st = new Stack<>();

    //     for(int i=0; i<n; i++){
    //         while(!st.isEmpty() && arr[i] < arr[st.peek()]){
    //             int idx = st.pop();
    //             ans[idx] = i;
    //         }

    //         st.push(i);
    //     }

    //     return ans;
    // }

    // public static int[] NSEonLeft(int[] arr, int n){
    //     int[] ans = new int[n];
    //     Arrays.fill(ans, -1);
    //     Stack<Integer> st = new Stack<>();

    //     for(int i=n-1; i>=0; i--){
    //         while(!st.isEmpty() && arr[i] < arr[st.peek()]){
    //             int idx = st.pop();
    //             ans[idx] = i;
    //         }

    //         st.push(i);
    //     }

    //     return ans;
    // }

    // public int largestRectangleArea(int[] heights) {
    //     int n = heights.length;
        
    //     int[] nseOnRight = NSEonRight(heights, n);
    //     int[] nseOnLeft = NSEonLeft(heights, n);

    //     int ans = Integer.MIN_VALUE;

    //     for(int i=0; i<n; i++){
    //         int height = heights[i];

    //         int x1 = nseOnRight[i] - 1;
    //         int x2 = nseOnLeft[i] + 1;
    //         int width = x1 - x2 + 1;

    //         int area = height * width;
    //         ans = Math.max(area, ans);
    //     }

    //     return ans;
    // }

    // In one pass
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        Stack<Integer> st = new Stack<>();
        int ans = 0;

        for(int i=0; i<=n; i++){
            int temp = 0;
            if(i != n){
                temp = heights[i];
            }
            while(!st.isEmpty() && temp < heights[st.peek()]){
                int tmp = st.pop(); 
                int nsr = i;
                int x1 = nsr - 1;
                int nsl = -1;
                if(!st.isEmpty()){
                    nsl = st.peek();
                }
                int x2 = nsl + 1;

                int area = ((x1 - x2) + 1) * heights[tmp];
                ans = Math.max(area, ans);
            }

            st.push(i);
        }

        return ans;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();

        int[] ans = new int[n];

        int i = 0;
        while(i < n){
            int count = 0;
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int idx = st.pop();
                ans[idx] = i - idx;
            }

            st.push(i);
            i++;
        }

        return ans;
    }
}
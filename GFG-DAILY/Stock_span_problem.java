class Solution {
    // Function to calculate the span of stock's price for all n days.
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[i] >= arr[st.peek()]){
                int idx = st.pop();
                ans[i] = ans[i] + ans[idx];
            }
            
            st.push(i);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(ans[i]);
        }
        
        return list;
    }
}
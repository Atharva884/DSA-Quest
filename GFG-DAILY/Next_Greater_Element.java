class Solution {
    // Function to find the next greater element for each element of the array.
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1));
        
        // for(int i = 0; i < n; i++) {
        //     ans.add(-1);
        // }
        
        for(int i=0; i<n; i++){
            
            while(!st.isEmpty() && arr[i] > arr[st.peek()]){
                int idx = st.pop();
                ans.set(idx, arr[i]);
            }
            
            st.push(i);
        }
        
        return ans;
    }
}
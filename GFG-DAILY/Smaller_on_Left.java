//User function Template for Java
class Solution{
    static List<Integer> leftSmaller(int n, int arr[])
    {
        List<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> st = new Stack<>();
        
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
                int idx = st.pop();
                ans.set(idx, arr[i]);
            }
            
            st.push(i);
        }
        
        return ans;
    }
}
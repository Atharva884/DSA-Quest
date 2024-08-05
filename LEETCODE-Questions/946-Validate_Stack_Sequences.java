class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;

        Stack<Integer> st = new Stack<>();

        int i = 0;
        int j = 0;

        while(i < n && j < n){
            // If they are same, pop it and move pointer
            if(pushed[i] == popped[j]){
                i++;
                j++;
            }else if(!st.isEmpty() && st.peek() == popped[j]){
                st.pop();
                j++;
            }else{
                st.push(pushed[i]);
                i++;
            }
        }

        while(j < n){
            if(!st.isEmpty() && st.peek() == popped[j]){
                st.pop();
            }
            j++;
        }

        return st.isEmpty();
    }
}

class StackQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    
    // TC: O(1), SC: O(1)
    public void push(int B) {
        s1.push(B);    
    }

    // TC: O(N + N) ~ O(N), SC: O(N)
    public int pop() {
        int n = s1.size();
        
        // Step 1) Remove all the first N-1 elements from the stack s1
        int i = 0;
        while(!s1.isEmpty() && i < n - 1){
            s2.push(s1.pop());
            i++;
        }
        
        int ans = !s1.isEmpty() ? s1.pop() : -1;

        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        
        return ans;
    }
}

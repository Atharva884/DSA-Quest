class Solution {
    // Optimal Approach
    // TC: O(2k + N-k) ~ O(k+N), SC: O(K)
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        if(q.size() < k) return q;
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<k; i++){
            st.push(q.poll());
        }
        
        while(!st.isEmpty()){
            q.add(st.pop());
        }
        
        int n = q.size();
        for(int i=0; i<n-k; i++){
            q.add(q.poll());
        }
        
        return q;
    }
}

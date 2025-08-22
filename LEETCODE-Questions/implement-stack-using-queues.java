// Brute Approach
// class MyStack {
//     Queue<Integer> q1;
//     Queue<Integer> q2;
//     public MyStack() {
//         q1 = new LinkedList<>();
//         q2 = new LinkedList<>();
//     }
    
//     // TC: O(1), SC: O(1)
//     public void push(int x) {
//         q1.add(x);
//     }
    
//     // TC: O(N + N) ~ O(2N), SC: O(N)
//     public int pop() {
//         int n = q1.size();

//         int i = 0;
//         while(!q1.isEmpty() && i < n-1){
//             q2.add(q1.poll());
//             i++;
//         }

//         int ans = q1.poll();

//         while(!q2.isEmpty()){
//             q1.add(q2.poll());
//         }

//         return ans;
//     }
    
//     // TC: O(N + N) ~ O(2N), SC: O(N)
//     public int top() {
//         int n = q1.size();
        
//         int i = 0;
//         while(!q1.isEmpty() && i < n-1){
//             q2.add(q1.poll());
//             i++;
//         }

//         int ans = q1.poll();

//         while(!q2.isEmpty()){
//             q1.add(q2.poll());
//         }
//         q1.add(ans);

//         return ans;   
//     }
    
//     // TC: O(1), SC: O(1)
//     public boolean empty() {
//         return q1.isEmpty();
//     }
// }

// Optimal Approach - Using Queue
class MyStack{
    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
    }

    public int pop() {
        int n = q.size();
        for(int i=0; i<n-1; i++){
            q.add(q.poll());
        }

        int ans = q.poll();

        return ans;
    }

    public int top() {
        int n = q.size();
        for(int i=0; i<n-1; i++){
            q.add(q.poll());
        }

        int ans = q.peek();
        q.add(q.poll());

        return ans;
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

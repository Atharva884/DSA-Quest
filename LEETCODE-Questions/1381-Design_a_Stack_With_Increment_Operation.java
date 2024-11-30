// class CustomStack {
//     Stack<Integer> st1;
//     Stack<Integer> st2;
//     int capacity;

//     public CustomStack(int maxSize) {
//         st1 = new Stack<>();
//         st2 = new Stack<>();
//         capacity = maxSize;
//     }

//     public void push(int x) {
//         if (st1.size() == capacity) {
//             return;
//         }

//         st1.push(x);
//     }

//     public int pop() {
//         if (!st1.isEmpty()) {
//             return st1.pop();
//         }

//         return -1;
//     }

//     public void increment(int k, int val) {
//         int n = st1.size();

//         if (k > n) {
//             // More than st.size()
//             while (!st1.isEmpty()) {
//                 int rem = st1.pop() + val;
//                 st2.push(rem);
//             }

//             while (!st2.isEmpty()) {
//                 st1.push(st2.pop());
//             }

//             return;
//         }

//         int diff = n - k;

//         int i = 0;
//         while (!st1.isEmpty() && i < diff) {
//             st2.push(st1.pop());
//             i++;
//         }

//         while (!st1.isEmpty()) {
//             int rem = st1.pop() + val;
//             st2.push(rem);
//         }

//         while (!st2.isEmpty()) {
//             st1.push(st2.pop());
//         }

//     }
// }

class CustomStack {
    int[] stack;
    // To store the operation that can be needed for future
    int[] operations;
    int size;
    int cap;
    int idx;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        operations = new int[maxSize];
        cap = maxSize;
        size = 0;
        idx = -1;
    }

    public void push(int x) {
        if(isFull()){
            return;
        }

        idx++;
        size++;
        stack[idx] = x;
    }

    public int pop() {
        if(isEmpty()){
            return -1;
        }

        // Whenerver popping, perform the updation and then pop
        int val = stack[idx];
        val += operations[idx];
        if(idx > 0){
            operations[idx-1] += operations[idx];
        }
        operations[idx] = 0;

        idx--;
        size--;

        return val;
    }

    // TC: O(N)

    // public void increment(int k, int val) {
    //     if(isEmpty()){
    //         return;
    //     }
    //     int num = Math.min(k, size);
    //     for(int i=0; i<num; i++){
    //         stack[i] += val;
    //     }
    // }

    // Doing it in O(1) (Lazy propogation/operation) -> {CP concept}
    public void increment(int k, int val) {
        if(isEmpty()){
            return;
        }
        int num = Math.min(k, size);
        // num-1 -> As array is a 0-indexed
        operations[num-1] += val;
    }

    public boolean isFull(){
        return (size == cap);
    }

    public boolean isEmpty(){
        return (size == 0);
    }
}



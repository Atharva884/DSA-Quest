class CustomStack {
    Stack<Integer> st1;
    Stack<Integer> st2;
    int capacity;

    public CustomStack(int maxSize) {
        st1 = new Stack<>();
        st2 = new Stack<>();
        capacity = maxSize;
    }

    public void push(int x) {
        if (st1.size() == capacity) {
            return;
        }

        st1.push(x);
    }

    public int pop() {
        if (!st1.isEmpty()) {
            return st1.pop();
        }

        return -1;
    }

    public void increment(int k, int val) {
        int n = st1.size();

        if (k > n) {
            // More than st.size()
            while (!st1.isEmpty()) {
                int rem = st1.pop() + val;
                st2.push(rem);
            }

            while (!st2.isEmpty()) {
                st1.push(st2.pop());
            }

            return;
        }

        int diff = n - k;

        int i = 0;
        while (!st1.isEmpty() && i < diff) {
            st2.push(st1.pop());
            i++;
        }

        while (!st1.isEmpty()) {
            int rem = st1.pop() + val;
            st2.push(rem);
        }

        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }

    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
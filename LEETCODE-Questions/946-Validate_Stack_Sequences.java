class Solution {
    // TC: O(N), SC: O(N)
    // public boolean validateStackSequences(int[] pushed, int[] popped) {
    //     int n = pushed.length;

    //     Stack<Integer> st = new Stack<>();

    //     int i = 0;
    //     int j = 0;

    //     while(i < n && j < n){
    //         // If they are same, pop it and move pointer
    //         if(pushed[i] == popped[j]){
    //             i++;
    //             j++;
    //         }else if(!st.isEmpty() && st.peek() == popped[j]){
    //             st.pop();
    //             j++;
    //         }else{
    //             st.push(pushed[i]);
    //             i++;
    //         }
    //     }

    //     while(j < n){
    //         if(!st.isEmpty() && st.peek() == popped[j]){
    //             st.pop();
    //         }
    //         j++;
    //     }

    //     return st.isEmpty();
    // }

    // StraightForward Approach
    public boolean validateStackSequences(int[] pushed, int[] popped){
        Stack<Integer> st = new Stack<>();
        int n = pushed.length;
        int i = 0;
        int j = 0;


        while(i < n){
            // Try inserting into the stack first and popped it if they are equal
            st.push(pushed[i]);
            i++;

            // Popped while they are equal
            while(!st.isEmpty() && st.peek() == popped[j]){
                st.pop();
                j++;
            }
        }

        return st.isEmpty();
    }
}

class Solution {
    public boolean isValid(String s) {
        int n = s.length();

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char brac = s.charAt(i);

            if (st.isEmpty() || brac == '{' || brac == '(' || brac == '[') {
                st.push(brac);
            } else {
                if (brac == '}' && st.peek() == '{') {
                    st.pop();
                } else if (brac == ']' && st.peek() == '[') {
                    st.pop();
                } else if (brac == ')' && st.peek() == '(') {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}
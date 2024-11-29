class Solution {
    public String clearDigits(String s) {
        int n = s.length();

        Stack<Character> st = new Stack<>();

        int i = 0;
        while(i < n){
            if(!Character.isDigit(s.charAt(i))){
                st.push(s.charAt(i));
            }else{
                st.pop();
            }

            i++;
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}
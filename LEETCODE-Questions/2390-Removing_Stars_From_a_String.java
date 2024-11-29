class Solution {
    public String removeStars(String s) {
        int n = s.length();

        // Stack<Character> st = new Stack<>();

        // int i = 0;

        // while(i < n){
        //     if(!st.isEmpty() && Character.isLetter(st.peek()) && s.charAt(i) == '*'){
        //         st.pop();
        //     }else{
        //         st.push(s.charAt(i));
        //     }

        //     i++;
        // }

        // StringBuilder sb = new StringBuilder();
        // while(!st.isEmpty()){
        //     sb.append(st.pop());
        // }


        StringBuilder sb = new StringBuilder();

        int i = 0;
        while(i < n){
            if(sb.length() != 0 && Character.isLetter(sb.charAt(sb.length() - 1)) && s.charAt(i) == '*'){
                sb.setLength(sb.length() - 1);
            }else{
                sb.append(s.charAt(i));
            }

            i++;
        }


        return sb.toString();
    }
}
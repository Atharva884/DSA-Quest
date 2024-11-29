class Solution {
    public String getCustomString(String s, int n){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(s);
        }

        return sb.toString();
    }

    public String decodeString(String s) {
        int n = s.length();
        Stack<String> st = new Stack<>();

        int i = 0; 
        while(i < n){
            char c = s.charAt(i);
            
            // If the digits are more than one
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                st.push(String.valueOf(num));
                i--;
            } else if (c == '[' || Character.isLetter(c)) {
                st.push(String.valueOf(c));
            }else{
                // We have encountered ']' then remove until '['
                StringBuilder sb = new StringBuilder(); 
                while(!st.isEmpty() && !st.peek().equals("[")){
                    sb.insert(0, st.pop());
                }
                st.pop(); // To remove "["
    
                int num = Integer.parseInt(st.pop());

                String str = getCustomString(sb.toString(), num);
                st.push(str);
            }

            i++;
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0, st.pop());
        }

        return sb.toString();   
    }
}
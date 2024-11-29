// User function Template for Java

class Solution {
    static String preToPost(String s) {
        int n = s.length();
        Stack<String> operand = new Stack<>();

        int i = n-1;
        while(i >= 0){
            char c = s.charAt(i);
            if(Character.isLetter(c)){
                operand.push(c + "");
            }else if(c == '+' || c == '-' || c == '*' || c == '/'){
                String val1 = operand.pop();
                String val2 = operand.pop();
                
                String ans = val1 + val2 + c;
                operand.push(ans);
            }
            
            i--;
        }
        
        return operand.peek();

    }
}

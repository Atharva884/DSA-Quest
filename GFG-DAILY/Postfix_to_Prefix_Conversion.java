// User function Template for Java

class Solution {
    static boolean isOperator(char c){
        return c == '+' || c == '-' || c == '/' || c == '*';
    }
    
    static String postToPre(String s) {
        // Prefix form -> op val1 val2
        int n = s.length();
        Stack<String> operand = new Stack<>();
        
        int i = 0;
        
        while(i < n){
            char c = s.charAt(i);
            if(!isOperator(c)){
                operand.push(String.valueOf(c));
            }else if(isOperator(c)){
                
                String val2 = operand.pop();
                String val1 = operand.pop();
                
                String ans = c + val1 + val2;
                operand.push(ans);
            }
            
            i++;
        }
     
        return operand.peek();   
    }
}

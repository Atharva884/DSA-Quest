class Solution {
    public static int prec(char c){
        if(c == '+' || c == '-'){
            return 0;
        }else if(c == '*' || c == '/'){
            return 1;
        }else{
            return 2;
        }
    }
    
    public static boolean isOperator(char c){
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(' || c == ')'; 
    }
    
    public static String infixToPostfix(String s) {
        int n = s.length();
        Stack<String> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();


        int i = 0;
        while(i < n){
            char c = s.charAt(i);
            
            if(!isOperator(c)){
                // It's character
                StringBuilder sb = new StringBuilder();
                while(i < n && !isOperator(s.charAt(i))){
                    sb.append(s.charAt(i));
                    i++;
                }
                
                operand.push(sb.toString());
                i--;
            }else if(c == '+' || c == '-' || c == '/' || c == '*' || c == '^'){
                // As '(' is not any operator 
                while(!operator.isEmpty() && operator.peek() != '(' && prec(s.charAt(i)) <= prec(operator.peek())){
                    char op = operator.pop();
                    String s2 = operand.pop();
                    String s1 = operand.pop();
                    
                    // As Infix to Postfix
                    // val1 val2 op
                    String ans = s1+s2+op;
                    operand.push(ans);
                }
                
                operator.push(s.charAt(i));
            }else if(c == '('){
                operator.push(s.charAt(i));
            }else{
                // Once encountered closing don't consider precedence as it was maintained just remove until we encounter '('
                // Closing bracket
                while(operator.peek() != '('){
                    char op = operator.pop();
                    String s2 = operand.pop();
                    String s1 = operand.pop();
                    
                    // As Infix to Postfix
                    // val1 val2 op
                    String ans = s1+s2+op;
                    operand.push(ans);
                }
                
                operator.pop(); // To remove '(' opening bracket
            }
            
            
            i++;
        }
        
        while(!operator.isEmpty()){
            char op = operator.pop();
            String s2 = operand.pop();
            String s1 = operand.pop();
            
            // As Infix to Postfix
            // val1 val2 op
            String ans = s1+s2+op;
            operand.push(ans);
        }
        
        return operand.peek();
    }
}
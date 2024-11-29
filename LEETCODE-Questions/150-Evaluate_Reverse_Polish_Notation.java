class Solution {
    public boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public int cal(int a, int b, String s){
        if(s.equals("+")){
            return a+b;
        }else if(s.equals("-")){
            return a-b;
        }else if(s.equals("*")){
            return a*b;
        }else{
            return a/b;
        }
    }

    public int evalRPN(String[] tokens) {
        // Reverse Polish Notation -> Postfix Expression
        // Postfix -> val1 val2 op

        // Postfix expression is converted from infix itself so
        // precedence is maintained
        Stack<Integer> operand = new Stack<>();
        
        int n = tokens.length;

        int i=0;
        while(i < n){
            String s = tokens[i];
            if(!isOperator(s)){
                operand.push(Integer.parseInt(s));
            }else if(isOperator(s)){
                int val2 = operand.pop();
                int val1 = operand.pop();

                int ans = cal(val1, val2, s);
                operand.push(ans);
            }

            i++;
        }

        return operand.peek();
    }
}
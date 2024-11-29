class Solution {
    public int cal(int a, int b, char c) {
        if (c == '+') {
            return a + b;
        } else if (c == '-') {
            return a - b;
        } else if (c == '*') {
            return a * b;
        } else {
            return a / b;
        }
    }

    public int prec(char c) {
        if (c == '+' || c == '-') {
            return 0;
        } else {
            return 1;
        }
    }

    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();

        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int num = 0;
                while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }

                operand.push(num);
                i--;
            } else if (c == '+' || c == '-' || c == '/' || c == '*') {
                while (!operator.isEmpty() && prec(s.charAt(i)) <= prec(operator.peek())) {
                    char op = operator.pop();
                    int val2 = operand.pop();
                    int val1 = operand.pop();

                    int ans = cal(val1, val2, op);
                    operand.push(ans);
                }

                operator.push(s.charAt(i));
            }

            i++;
        }

        while (!operator.isEmpty()) {
            char op = operator.pop();
            int val2 = operand.pop();
            int val1 = operand.pop();

            int ans = cal(val1, val2, op);
            operand.push(ans);
        }

        return operand.pop();
    }
}
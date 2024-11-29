class Solution {
    public int lengthLongestPath(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int maxLength = 0;
        int i = 0;

        while (i < n) {
            int level = 0;
            while (i < n && s.charAt(i) == '\t') {
                level++;
                i++;
            }

            StringBuilder sb = new StringBuilder();
            while (i < n && s.charAt(i) != '\n') {
                sb.append(s.charAt(i));
                i++;
            }
            String current = sb.toString();

            while (stack.size() > level + 1) {
                stack.pop();
            }

            int length = stack.peek() + current.length() + 1;

            if (current.contains(".")) { 
                maxLength = Math.max(maxLength, length - 1); 
            } else { 
                stack.push(length);
            }

            i++;
        }

        return maxLength;
    }
}

class Solution {
    public String simplifyPath(String path) {
        int n = path.length();

        Stack<String> st = new Stack<>();

        int i = 0;

        while (i < n) {
            StringBuilder sb = new StringBuilder();
            if (path.charAt(i) == '/') {
                sb.append(path.charAt(i));
                i++;
            }

            while (i < n && path.charAt(i) == '/') {
                i++;
            }

            while (i < n && path.charAt(i) != '/') {
                sb.append(path.charAt(i));
                i++;
            }

            String str = sb.toString();


            if (str.equals("/.") || (str.equals("/") && i - 1 == n - 1)) {
                continue;
            }

            if (str.equals("/..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
                continue;
            }

            if (!str.equals("/")) {
                st.push(str);
            }
        }

        if(st.size() == 0){
            return "/";
        }

        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.insert(0, st.pop());
        }

        return ans.toString();
    }
}
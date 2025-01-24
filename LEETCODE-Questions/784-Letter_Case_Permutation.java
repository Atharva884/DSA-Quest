class Solution {
    public static void solve(int i, String s, StringBuilder sb, List<String> ans, int n){
        if(i >= n){
            ans.add(sb.toString());
            return;
        }

        char cur = s.charAt(i);

        if(Character.isLetter(cur)){
            // Convert to uppercase
            sb.append(Character.toUpperCase(cur));
            solve(i+1, s, sb, ans, n);
            sb.setLength(sb.length() - 1);
            
            // Convert to lowercase
            sb.append(Character.toLowerCase(cur));
            solve(i+1, s, sb, ans, n);
            sb.setLength(sb.length() - 1);
        }else{
            sb.append(cur);
            solve(i+1, s, sb, ans, n);
            sb.setLength(sb.length() - 1);
        }

    }

    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        solve(0, s, sb, ans, s.length());

        return ans;
    }
}
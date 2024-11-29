class Solution {
    // public String removeOccurrences(String s, String part) {
    //     int n = s.length();

    //     int k = part.length();


    //     if(k > n){
    //         return s;
    //     }

    //     Stack<Character> st = new Stack<>();
    //     char lastChar = part.charAt(k-1);

    //     int i = 0;

    //     while(i < n){
    //         st.push(s.charAt(i));

    //         if(st.peek() == lastChar){
    //             int j = k-1;
    //             int count = 0;

    //             Stack<Character> tmp = new Stack<>();
    //             while(!st.isEmpty() && j >= 0 && st.peek() == part.charAt(j)){
    //                 tmp.push(st.pop());
    //                 count++;
    //                 j--;
    //             }

    //             // If not matches, restore the popped element
    //             if(count != k){
    //                 while(!tmp.isEmpty()){
    //                     st.push(tmp.pop());
    //                 }
    //             }
    //         }

    //         i++;
    //     }

    //     StringBuilder sb = new StringBuilder();
    //     while(!st.isEmpty()){
    //         sb.append(st.pop());
    //     }

    //     return sb.reverse().toString();
    // }

    public String removeOccurrences(String s, String part){
        int n = s.length();
        int k = part.length();

        if(k > n){
            return s;
        }

        StringBuilder sb = new StringBuilder();

        int i = 0;

        while(i < n){
            sb.append(s.charAt(i));

            // daabcbaabcbc
            if(sb.length() >= k && sb.substring(sb.length() - k).equals(part)){
                sb.setLength(sb.length() - k);
            }
            

            i++;
        }

        return sb.toString();
    }
}
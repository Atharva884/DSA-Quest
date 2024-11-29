class Solution {
    // Memory Limit Exceeded

    // public boolean isDigit(String str){
    //     for(int i=0; i<str.length(); i++){
    //         char c = str.charAt(i);
    //         if(c >= '2' && c <= '9'){
    //             return true;
    //         }
    //     }

    //     return false;
    // }

    // public int getNum(String str){
    //     int num = 0;

    //     for(int i=0; i<str.length(); i++){
    //         char c = str.charAt(i);
    //         if(c >= '2' && c <= '9'){
    //             num = num * 10 + (c - '0');
    //         }
    //     }

    //     return num;
    // }

    // public String decodeAtIndex(String s, int k) {
    //     int n = s.length();

    //     Stack<String> st = new Stack<>();

    //     int i = 0;
    //     while(i < n){
    //         StringBuilder sb = new StringBuilder();
    //         if(i < n && !Character.isDigit(s.charAt(i))){
    //             while(i < n && !Character.isDigit(s.charAt(i))){
    //                 sb.append(s.charAt(i));
    //                 i++;
    //             }
    //         }else{
    //             sb.append(s.charAt(i));
    //             i++;
    //         }

    //         String newStr = sb.toString();
    //         if(isDigit(newStr)){
    //             String str = st.peek();
    //             StringBuilder sb1 = new StringBuilder();
    //             for(int j=0; j < getNum(newStr) - 1; j++){
    //                 sb1.append(str);
    //             }
    //             st.push(str + sb1.toString());
    //         }else{
    //             if(!st.isEmpty()){
    //                 String str = st.peek();
    //                 st.push(str + newStr);
    //             }else{
    //                 st.push(newStr);
    //             }
    //         }

    //         if(st.peek().length() >= k){
    //             break;
    //         }
    //     }

    //     return String.valueOf(st.peek().charAt(k-1));
    // }

    public String decodeAtIndex(String s, int k){
        int n = s.length();

        long size = 0;

        for(int i=0; i<n; i++){
            if(Character.isDigit(s.charAt(i))){
                size = size * (s.charAt(i) - '0');
            }else{
                size = size + 1;
            }
        }

        int i = n-1;
        while(i >= 0){
            k = (int) (k % size);

            if(k == 0 && !Character.isDigit(s.charAt(i))){
                return String.valueOf(s.charAt(i));
            }

            if(Character.isDigit(s.charAt(i))){
                size = size / (s.charAt(i) - '0');
            }else{
                size = size - 1;
            }

            i--;
        }

        return "";
    }
}
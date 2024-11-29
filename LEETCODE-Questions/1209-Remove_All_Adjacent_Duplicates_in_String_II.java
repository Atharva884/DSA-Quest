class Pair{
    char c;
    int count;

    public Pair(char _c, int _count){
        this.c = _c;
        this.count = _count;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        Stack<Pair> st = new Stack<>();

        int i = 0;

        while(i < n){
            if(!st.isEmpty() && s.charAt(i) == st.peek().c){
                Pair rem = st.pop();
                rem.count++;

                if(rem.count < k){
                    st.push(rem);
                }
            }else{
                st.push(new Pair(s.charAt(i), 1));
            }

            i++;
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            Pair rem = st.pop();
            if(rem.count > 1){
                for(int j=0; j<rem.count; j++){
                    sb.append(rem.c);
                }
                continue;
            }
            sb.append(rem.c);
        }

        return sb.reverse().toString();
    }
}
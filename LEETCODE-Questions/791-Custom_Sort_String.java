class Solution {
    // TC: O(O + S), SC: O(S)
    public String customSortString(String order, String s) {
        int[] arr = new int[26];
        int[] temp = new int[26];

        for(char c: order.toCharArray()){
            arr[c - 97]++;
        }

        for(char c: s.toCharArray()){
            temp[c - 97]++;
        }

        StringBuilder sb = new StringBuilder();
        for(char c: order.toCharArray()){
            int idx = c - 97;
            if(arr[idx] == 1){
                for(int j=0; j<temp[idx]; j++){
                    sb.append(c);
                }

                temp[idx] = 0;
            }
        }

        for(int i=0; i<26; i++){
            for(int j=0; j<temp[i]; j++){
                sb.append((char) (97 + i));
            }
        }

        return sb.toString();
    }
}
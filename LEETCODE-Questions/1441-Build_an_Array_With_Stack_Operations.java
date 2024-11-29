class Solution {
    // public List<String> buildArray(int[] target, int n) {
    //     int t = target.length;
    //     List<String> ans = new ArrayList<>();
    //     Stack<Integer> st = new Stack<>();

    //     int[] stream = new int[n];
    //     for(int i=0; i<n; i++){
    //         stream[i] = i+1;
    //     }

    //     int k = 0;
    //     int i = 0;
    //     while(k < t && i < n){
    //         if(target[k] == stream[i]){
    //             while((k == 0 && st.size() > 0) || st.size() == t || 
    //                 (k-1 >= 0 && target[k-1] != st.peek())){
    //                 ans.add("Pop");
    //                 st.pop();
    //             }

    //             st.push(stream[i]);
    //             ans.add("Push");
    //             k++;
    //         }else{
    //             st.push(stream[i]);
    //             ans.add("Push");
    //         }

    //         i++;
    //     }

    //     return ans;
    // }

    public List<String> buildArray(int[] target, int n) {
        int t = target.length;
        List<String> ans = new ArrayList<>();

        int[] stream = new int[n];
        for(int i=0; i<n; i++){
            stream[i] = i+1;
        }

        int k = 0;
        int i = 0;
        while(k < t && i < n){
            if(target[k] == stream[i]){
                ans.add("Push");
                k++;
            }else{
                ans.add("Push");
                ans.add("Pop");
            }

            i++;
        }

        return ans;
    }
}
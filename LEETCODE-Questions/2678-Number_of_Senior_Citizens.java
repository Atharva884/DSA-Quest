class Solution {
    public int countSeniors(String[] details) {
        // int ans = 0;

        // int n = details.length;

        // for(int i=0; i<n; i++){
        //     String str = details[i];

        //     char a = str.charAt(11);
        //     // char b = str.charAt(12);
        //     // String age = a + "" + b;
        //     if(a > '6'){
        //         ans++;
        //     }

        // }

        // return ans;

        int ans = 0;
        for(String passenger: details){
            if(Integer.parseInt(passenger.substring(11,13))>60){
                ans+=1;
            }
        }
        return ans;
    }
}
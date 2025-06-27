// User function Template for Java

class Solution {
    // Brute Force Approach
    // TC: O(pat * text) i,e O(K * N) if k is half of N then N * (n/2) which is O(N^2), SC: O(1)
    // int search(String text, String pat) {
        
    //     int n1 = text.length();
    //     int n2 = pat.length();
        
    //     int i = 0;
    //     int j = 0;
        
    //     while(i < n1){
    //         int start = i;
            
    //         while(i < n1 && j < n2 && text.charAt(i) == pat.charAt(j)){
    //             i++;
    //             j++;
    //         }
        
            
    //         if(j == n2){
    //             return 1;
    //         }
            
    //         j = 0;
            
    //         i = start + 1;
    //     }


    //     return 0;
    // }
    
    
    // Brute Force, Currently O(N^3) worst than above one -> But can be improved
    public static int LPSOfString(String s, int n){
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;

        for(int i=0; i<n-1; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<=i; j++){
                sb.append(s.charAt(j));
            }

            map.put(sb.toString(), sb.length());
        }

        for(int i=n-1; i>0; i--){
            StringBuilder sb = new StringBuilder();
            for(int j=i; j<n; j++){
                sb.append(s.charAt(j));
            }
            
            if(map.containsKey(sb.toString())){
                max = Math.max(max, map.get(sb.toString()));
            }
        }
        
        return max;
    }
    
    public static int[] LPSArray(String s, int n){
        int[] lps = new int[n];
        
        for(int i=0; i<n; i++){
            String str = s.substring(0, i+1);
            lps[i] = LPSOfString(str, str.length());
        }
        
        return lps;
    }
    
    int search(String text, String pat){
        String str = pat + "#" + text;
        int n = str.length();
        
        int[] lps = LPSArray(str, n);
        
        for(int i=0; i<n; i++){
            if(lps[i] == pat.length()){
                return 1;
            }
        }
        
        return 0;
    }
};

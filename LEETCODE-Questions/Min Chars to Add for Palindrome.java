// User function Template for Java

class Solution {
    // public static boolean isPalindrome(String str, int n){
    //     int i = 0;
    //     int j = n-1;
        
    //     while(i < j){
    //         if(str.charAt(i) != str.charAt(j)){
    //             return false;
    //         }
            
    //         i++;
    //         j--;
    //     }
        
    //     return true;
    // }
    
    // Brute Force Approach
    // TC: O(N^2), SC: O(1)
    
    // public static int minChar(String s) {
    //     int n = s.length();
    //     int k = 0;
        
    //     for(int i=n-1; i>=0; i--){
    //         String str = s.substring(0, i + 1);
            
    //         if(isPalindrome(str, str.length())){
    //             break;
    //         }
            
    //         k++;
    //     }
        
    //     return k;
    // }
    
    
    public static String reverse(char[] arr){
        int n = arr.length;
        
        int i = 0;
        int j = n-1;
        
        while(i < j){
            char temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            
            i++;
            j--;
        }
        
        return String.valueOf(arr);
    }
    
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
    
    // Brute Force Approach, Currently worst than the above
    // TC: O(N^3), SC: O(N)
    public static int minChar(String s) {
        String str = s + "#" + reverse(s.toCharArray());
        
        int[] lps = LPSArray(str, str.length());
        
        int max = 0;
        for(int a: lps){
            max = Math.max(a, max);
        }
        
        return s.length() - max;
    }
}

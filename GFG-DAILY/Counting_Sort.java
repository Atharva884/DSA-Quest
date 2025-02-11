class Solution
{
    // Count Sort -> It would always be beneficial to apply on string as there are 
    // altogether 256 characters
    // TC: O(N), SC: O(N)
    public static String countSort(String arr){
        int[] count = new int[26];
        
        for(char c: arr.toCharArray()){
            count[c - 97]++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<26; i++){
            int cnt = count[i];
            
            for(int k=0; k<cnt; k++){
                sb.append((char) (97 + i));
            }
        }
        
        return sb.toString();
    }
}
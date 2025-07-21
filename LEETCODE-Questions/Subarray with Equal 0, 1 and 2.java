// User function Template for Java
class Solution {
    static int[] prefixCount0(int[] arr){
        int n = arr.length;
        
        int[] pfCount = new int[n];
        if(arr[0] == 0){
            pfCount[0] = 1;
        }
        
        for(int i=1; i<n; i++){
            if(arr[i] == 0){
                pfCount[i] = pfCount[i-1] + 1;
            }else{
                pfCount[i] = pfCount[i-1];
            }
        }
        
        return pfCount;
    }
    
    static int[] prefixCount1(int[] arr){
        int n = arr.length;
        
        int[] pfCount = new int[n];
        if(arr[0] == 1){
            pfCount[0] = 1;
        }
        
        for(int i=1; i<n; i++){
            if(arr[i] == 1){
                pfCount[i] = pfCount[i-1] + 1;
            }else{
                pfCount[i] = pfCount[i-1];
            }
        }
        
        return pfCount;
    }
    
    static int[] prefixCount2(int[] arr){
        int n = arr.length;
        
        int[] pfCount = new int[n];
        if(arr[0] == 2){
            pfCount[0] = 1;
        }
        
        for(int i=1; i<n; i++){
            if(arr[i] == 2){
                pfCount[i] = pfCount[i-1] + 1;
            }else{
                pfCount[i] = pfCount[i-1];
            }
        }
        
        return pfCount;
    }
    
    
    static long subArraySumWithEquals0And1(int[] arr, int n){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("0@0", 1);
        
        int[] zeros = prefixCount0(arr);
        int[] ones = prefixCount1(arr);
        int[] twos = prefixCount2(arr);
        
        long count = 0; 
        
        int ep = 0;
        while(ep < n){
            int diff1 = zeros[ep] - ones[ep];
            int diff2 = ones[ep] - twos[ep];
            
            String str = diff1 + "@" + diff2;
            
            if(map.containsKey(str)){
                count += (long) map.get(str);
            }
            
            map.put(str, map.getOrDefault(str, 0) + 1);
                
            ep++;
        }
        
        return count;
    }
    
    
    long getSubstringWithEqual012(String str) {
        int n = str.length();
        
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++){
            arr[i] = str.charAt(i) - '0';
        }
        
        // Optimal Approach -> Generic
        // TC: O(N), SC: O(N)
        return subArraySumWithEquals0And1(arr, n);
    }
}

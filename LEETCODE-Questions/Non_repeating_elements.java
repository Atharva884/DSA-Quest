// User function Template for Java

class Solution {
    public int firstNonRepeating(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
    
        for(int i=0; i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(int num: arr){
            if(map.containsKey(num) && map.get(num) == 1){
                return num;
            }
        }
        
        return 0;
    }
}

class Solution {
    // TC: O(2N) ~ O(N), SC: O(N)
    public String kthDistinct(String[] arr, int k) {
        int n = arr.length;

        // Take HashMap and count the freq
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            String val = arr[i];
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        for(int i=0; i<n; i++){
            String val = arr[i];
            if(map.get(val) == 1){
                k = k - 1;
            }

            if(k == 0){
                return val;
            }
        }
       

        return "";
    }
}
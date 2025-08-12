class Solution {
    ArrayList<Integer> brute(int[] arr, int n, int k){
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int sp=0; sp <= n - k; sp++){
            HashSet<Integer> hs = new HashSet<>();
            for(int ep=sp; ep < sp + k; ep++){
                hs.add(arr[ep]);
            }
            ans.add(hs.size());
        }
        
        return ans;
    }
    
    ArrayList<Integer> optimal(int[] arr, int n, int k){
        ArrayList<Integer> ans = new ArrayList<>();
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<k; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);    
        }
        
        ans.add(map.size());
        
        int sp = 0;
        int ep = k;
        
        while(ep < n){
            map.put(arr[ep], map.getOrDefault(arr[ep], 0) + 1);
            map.put(arr[sp], map.get(arr[sp]) - 1);
            if(map.get(arr[sp]) == 0) map.remove(arr[sp]);
            
            ans.add(map.size());
            
            sp++;
            ep++;
        }
        
        return ans;
    }
    
    ArrayList<Integer> countDistinct(int arr[], int k) {
        int n = arr.length;
        
        // Brute Approach
        // TC: O(N^2), SC: O(k)
        // return brute(arr, n, k);
        
        // Optimal Approach
        // TC: O(N), SC: O(K)
        return optimal(arr, n, k);
    }
}

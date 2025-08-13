class Solution {
    static List<Integer> brute(int[] arr, int k){
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        
        for(int sp=0; sp <= n-k; sp++){
            boolean neg = false;
            for(int ep=sp; ep< sp + k; ep++){
                if(arr[ep] < 0){
                    neg = true;
                    ans.add(arr[ep]);
                    break;
                }
            }
            if(!neg) ans.add(0);
        }
        
        return ans;
    }
    
    static List<Integer> optimal(int[] arr, int k){
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<k; i++){
            if(arr[i] < 0){
                q.add(arr[i]);
            }
        }
        
        ans.add(q.isEmpty() ? 0 : q.peek());
        
        int sp = 0;
        int ep = k;
        
        while(ep < n){
            if(arr[ep] < 0){
                q.add(arr[ep]);
            }
            
            if(arr[sp] < 0 && !q.isEmpty()){
                q.poll();
            }
            
            ans.add(q.isEmpty() ? 0 : q.peek());
            
            sp++;
            ep++;
        }
        
        return ans;
    }
    
    static List<Integer> firstNegInt(int arr[], int k) {
        // Brute Approach -- TLE
        // TC: O(N * K), SC: O(1)
        // return brute(arr, k);
        
        // Optimal Approach
        // TC: O(N), SC: O(K)
        return optimal(arr, k);
    }
}

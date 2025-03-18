//User function Template for Java

class Solution {
    // Sorting and HashMap Approach
    // TC: O(NlogN), SC: O(2N) -> {Not considering output arr}
    
    static int[] replaceWithRank(int arr[], int N) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int[] b = arr.clone();
        Arrays.sort(b);
        
        
        int rank = 1;
        for(int num: b){
            if(map.containsKey(num)) continue;
            
            map.put(num, rank++);
        }
        
        int[] ans = new int[N];
        int i = 0;
        for(int num: arr){
            ans[i++] = map.get(num);
        }
        
        return ans;
    }
    
    // Heap and HashMap Approach -> { Overhead -> Nhi chal raha }
    // TC: O(NlogN), SC: O(2N) -> {Not considering output arr}
    
    // static int[] replaceWithRank(int arr[], int N) {
    //     PriorityQueue<Integer> pq = new PriorityQueue<>();
    //     for(int num: arr){
    //         pq.add(num);
    //     }
        
    //     HashMap<Integer, Integer> map = new HashMap<>();
        
    //     int rank = 1;
    //     while(!pq.isEmpty()){
    //         int elem = pq.poll();
    //         if(map.containsKey(elem)) continue;
            
    //         map.put(elem, rank++);
    //     }
        
    //     int[] ans = new int[N];
        
    //     int i = 0;
    //     for(int num: arr){
    //         ans[i++] = map.get(num);
    //     }
        
    //     return ans;
    // }
}
     
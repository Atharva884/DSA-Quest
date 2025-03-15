// User function Template for Java

class Solution {
    // TC: O(NlogK), SC: O(k)
    public static int kthSmallest(int[] arr, int k) {
        int n = arr.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int num: arr){
            pq.add(num);
            
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        return pq.peek();
    }
}

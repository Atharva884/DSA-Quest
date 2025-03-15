class Solution {
    // TC: O(NlogK), SC: O(K)
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int arr: nums){
            pq.add(arr);

            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.poll();
    }
}
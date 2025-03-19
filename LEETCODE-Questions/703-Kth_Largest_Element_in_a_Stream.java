class KthLargest {
    PriorityQueue<Integer> pq;
    int cap;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        cap = k;

        for(int num: nums){
            pq.add(num);
        }
    }
    
    public int add(int val) {
        pq.add(val);

        while(pq.size() > cap){
            pq.poll();
        }

        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
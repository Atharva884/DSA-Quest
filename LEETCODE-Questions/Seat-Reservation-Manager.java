class SeatManager {
    PriorityQueue<Integer> pq;
    
    // TC: O(NlogN), SC: O(N)
    public SeatManager(int n) {
        pq = new PriorityQueue<>();

        for(int i=1; i<=n; i++){
            pq.add(i);
        }
    }

    // TC: O(logN)
    public int reserve() {
        // int val = pq.poll();
        // hs.add(val);

        return pq.poll();
    }
    
    // TC: O(logN)
    public void unreserve(int seatNumber) {
        // if(hs.contains(seatNumber)){
            // hs.remove(seatNumber);
            pq.add(seatNumber);
        // }   
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */

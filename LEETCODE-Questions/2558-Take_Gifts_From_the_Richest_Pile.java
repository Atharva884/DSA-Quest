class Solution {
    // TC: O(N + K), SC: O(N)
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int gift: gifts) pq.add((long) gift);

        while(k-- > 0){
            long rem = pq.poll();
            pq.add((long) Math.sqrt(rem));
        }

        long ans = 0;
        while(!pq.isEmpty()){
            ans += pq.poll();
        }

        return ans;
    }
}
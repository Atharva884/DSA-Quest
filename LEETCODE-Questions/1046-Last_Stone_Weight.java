class Solution {
    // TC: O(NlogN), SC: O(N)
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone: stones){
            pq.add(stone);
        }

        while(!pq.isEmpty() && pq.size() != 1){
            int y = pq.poll();
            int x = pq.poll();

            if(x != y){
                pq.add(y - x);
            }
        }

        return pq.size() == 0 ? 0 : pq.peek();
    }
}
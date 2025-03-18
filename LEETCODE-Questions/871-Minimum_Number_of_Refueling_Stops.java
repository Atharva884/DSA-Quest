class Solution {
    // TC: O(NlogN), SC: O(N)
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int fuel = startFuel;
        int count = 0;

        int i = 0;

        while(fuel < target){
            while(i < n && stations[i][0] <= fuel){
                pq.add(stations[i][1]);
                i++;
            }

            if(pq.isEmpty()) return -1;

            fuel += pq.poll();
            count++;
        }

        return count;
    }
}
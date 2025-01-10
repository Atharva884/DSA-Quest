class Solution {
    // TC: O(N^2), SC: O(N^2)
    public boolean canCross(int[] stones) {
        int n = stones.length;

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }

        // Intially, the frog is on the 1st stone with 1 jump
        map.get(0).add(1);

        for (int i = 0; i < n; i++) {
            int st = stones[i];

            for(int k: map.get(st)){
                int vs = st + k;

                // If we have reached the target, then return true
                if(vs == stones[n-1]) return true;

                // You check by using that jump u reached to the valid stone or not
                if(map.containsKey(vs)){
                    // Handling negative case, so that i can't go backward
                    if(k - 1 > 0){
                        map.get(vs).add(k-1);
                    }

                    // You just keep on adding, and the map is checking for valid jump
                    map.get(vs).add(k);
                    map.get(vs).add(k+1);
                }

            }
        }

        return false;
    }
}
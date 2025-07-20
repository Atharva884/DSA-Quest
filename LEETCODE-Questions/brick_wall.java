class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(List<Integer> list: wall){
            int n = list.size();
            int pfSum = list.get(0);

            for(int i=1; i<n; i++){
                map.put(pfSum, map.getOrDefault(pfSum, 0) + 1);
                pfSum = pfSum + list.get(i);
            }
        }

        int max = 0;
        for(int key: map.keySet()){
            max = Math.max(map.get(key), max);
        }

        return wall.size() - max;
    }
}

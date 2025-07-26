class Solution {
    public List<List<Integer>> bucketSort(HashMap<Integer, Integer> map, int max) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= max; i++) {
            list.add(new ArrayList<>());
        }

        for (int key : map.keySet()) {
            int val = map.get(key);

            list.get(val).add(key);
        }

        return list;
    }

    // Optimal Soln
    // TC: O(N), SC: O(N)
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k];
        int max = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(max, map.get(num));
        }

        List<List<Integer>> bucket = bucketSort(map, max);

        int counter = 0;
        for(int i=max; i>=0; i--){
            if(k == 0) break;
            List<Integer> temp = bucket.get(i);

            int j = 0;
            while(j < temp.size() && counter < k){
                ans[counter++] = temp.get(j);
                j++;
            }
        }

        return ans;
    }
}

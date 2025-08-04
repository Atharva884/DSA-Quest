class Solution {
    HashMap<Integer, List<Integer>> map;
    Random r;

    public Solution(int[] nums) {
        int n = nums.length;
        map = new HashMap<>();
        r = new Random();

        for(int i=0; i<n; i++){
            int num = nums[i];
            List<Integer> temp = map.getOrDefault(num, new ArrayList<>());
            temp.add(i);
            map.put(num, temp);
        }

        // System.out.println(map);
    }
    
    public int pick(int target) {
        List<Integer> arr = map.get(target);

        int idx = r.nextInt(arr.size());
        return arr.get(idx);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

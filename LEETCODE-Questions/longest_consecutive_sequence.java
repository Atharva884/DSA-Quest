class Solution {
    
    public int brute(int[] nums){
        int n = nums.length;

        if(n == 0) return 0;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int num: nums){
            map.put(num, -1);
        }

        if(map.size() == 1) return 1;

        int count = 1;
        int firstKey = map.firstKey();
        int ans = 0;

        for(int key: map.keySet()){
            if(key - firstKey == 0) continue;

            if(key - firstKey == 1) {
                count++;
            }else if(key - firstKey > 1){   
                ans = Math.max(count, ans);
                count = 1;
            }

            firstKey = key;
            ans = Math.max(count, ans);
        }

        return ans;
    }

    public int optimal(int[] nums){
        int n = nums.length;
        if(n == 0) return 0;

        HashSet<Integer> hs = new HashSet<>();
        for(int num: nums){
            hs.add(num);
        }

        int longest = 1;

        for(int val: hs){
            if(hs.contains(val - 1)){
                continue;
            }

            int cnt = 0;
            int num = val;
            while(hs.contains(num)){
                cnt++;
                num += 1;
            }

            longest = Math.max(cnt, longest);
        }

        return longest;
    }

    public int longestConsecutive(int[] nums) {
        // Brute Approach
        // TC: O(NlogN), SC: O(N)
        // return brute(nums); 

        // Optimal Approach
        // TC: O(N), SC: O(N)
        return optimal(nums);  
    }
}

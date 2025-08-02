class Solution {
    // TC: O(N * klogk) where k is a size of string of each string, SC: O(N)
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        int n = strs.length;

        HashMap<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            String s = str;
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            StringBuilder sb = new StringBuilder(String.valueOf(arr));

            List<String> temp = map.getOrDefault(sb.toString(), new ArrayList<>());
            temp.add(str);
            map.put(sb.toString(), temp);
        }

        for(String key: map.keySet()){
            ans.add(map.get(key));
        }

        return ans;
    }
}

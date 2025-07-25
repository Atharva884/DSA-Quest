class Solution {
    // TC: O(N), SC: O(N)
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        for(String str: strs){
            sb.append(str + "u001" + idx + "u002");
            idx++;
        }

        return sb.toString();
    }

    // TC: O(N), SC: O(N)
    public List<String> decode(String str) {
        List<String> arr = new ArrayList<>();
        String[] strs = str.split("u002");

        if(str.length() == 0){
            return arr;
        }

        if(strs.length == 0){
            arr.add(0, "");
            return arr;
        }
        
        for(String a: strs){
            String[] split = a.split("u001");
            String s = split[0];
            int idx = Integer.parseInt(split[1]);
            arr.add(idx, s);
        }

        return arr;        
    }
}

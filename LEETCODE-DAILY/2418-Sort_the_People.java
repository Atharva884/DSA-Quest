import java.util.*;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        TreeMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            map.put(heights[i], names[i]);
        }

        int i = 0;
        for (Map.Entry<Integer, String> key : map.entrySet()) {
            names[i++] = key.getValue();
        }

        return names;
    }

    // public String[] sortPeople(String[] names, int[] heights){
    // TreeMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());

    // int n = names.length;
    // for(int i=0; i<n; i++){
    // map.put(heights[i], names[i]);
    // }

    // int i=0;
    // for(int key: map.keySet()){
    // names[i++] = map.get(key);
    // }

    // return names;
    // }
}
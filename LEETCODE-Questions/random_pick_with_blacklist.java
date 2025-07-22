// Brute Approach
// TC: O(N), SC: O(N)

// class Solution {
//     Random r;
//     ArrayList<Integer> arr;
//     HashSet<Integer> hs;

//     public Solution(int n, int[] blacklist) {
//         r = new Random();
//         arr = new ArrayList<>();
//         hs = new HashSet<>();

//         for(int num: blacklist){
//             hs.add(num);
//         }

//         for(int i=0; i<n; i++){
//             if(!hs.contains(i)){
//                 arr.add(i);
//             }
//         }
//     }
    
//     public int pick() {
//         return arr.get(r.nextInt(0, arr.size()));    
//     }
// }

// Optimal Approach
// TC: O(M) where m is blacklist.length, SC: O(M)

class Solution {
    Random r;
    HashMap<Integer, Integer> map;
    int valid;

    public Solution(int n, int[] blacklist) {
        map = new HashMap<>();
        r = new Random();

        int m = blacklist.length;
        valid = n - m;

        for(int num: blacklist){
            map.put(num, -1);
        }   

        int last = n-1;

        for(int i=0; i<m; i++){
            // We need to map this blacklist
            if(blacklist[i] < valid){
                while(map.containsKey(last)) last--;
                map.put(blacklist[i], last);
                last--;
            }
        }
    }
    
    public int pick() {
        int val = r.nextInt(0, valid);
        if(map.containsKey(val)){
            return map.get(val);
        }

        return val;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */

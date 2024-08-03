class Solution {
    // TC: O(m+n), SC: O(m+n)
    // public int winningPlayerCount(int n, int[][] pick) {
    //     int m = pick.length;
    //     int ans = 0;

    //     HashMap<String, Integer> map = new HashMap<>();

    //     for(int i=0; i<m; i++){
    //         int person = pick[i][0];
    //         int ballColor = pick[i][1];

    //         String str = person + "-" + ballColor;

    //         map.put(str, map.getOrDefault(str, 0) + 1);
    //     }
    
    //     boolean[] winningPlayers = new boolean[n];

    //     for(String str: map.keySet()){
    //         String[] arr = str.split("-");
    //         int person = Integer.parseInt(arr[0]);

    //         if (map.get(str) > person) {
    //             winningPlayers[person] = true;
    //         }
    //     }
        
    //     for(boolean win: winningPlayers){
    //         if(win){
    //             ans++;
    //         }
    //     }

    //     return ans;

        
    // }

    // TC: O(m), SC: O(m+n)
    public int winningPlayerCount(int n, int[][] pick){
        int m = pick.length;
        int ans = 0;
    
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<Integer> winningPlayers = new HashSet<>();

        for(int i = 0; i < m; i++) {
            int person = pick[i][0];
            int ballColor = pick[i][1];

            String str = person + "-" + ballColor;

            map.put(str, map.getOrDefault(str, 0) + 1);

            if (map.get(str) > person) {
                winningPlayers.add(person);
            }
        }

        ans = winningPlayers.size();

        return ans;
    }
}
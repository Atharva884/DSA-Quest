class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        
        boolean[] vis = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;

        while(!q.isEmpty()){
            int rem = q.poll();

            for(int nbr: rooms.get(rem)){
                if(!vis[nbr]){
                    q.add(nbr);
                    vis[nbr] = true;
                }
            }
        }

        for(int i=0; i<n; i++){
            if(vis[i] == false){
                return false;
            }
        }

        return true;
    }
}
class Pair implements Comparable<Pair> {
    int server;
    int idx;

    public Pair(int _server, int _idx) {
        this.server = _server;
        this.idx = _idx;
    }

    public int compareTo(Pair o) {
        if (this.server == o.server) {
            return this.idx - o.idx;
        }
        return this.server - o.server;
    }
}

class Tuple implements Comparable<Tuple> {
    int server;
    int free;
    int idx;

    public Tuple(int _server, int _free, int _idx) {
        this.server = _server;
        this.free = _free;
        this.idx = _idx;
    }

    public int compareTo(Tuple o) {
        if (this.free == o.free) {
            return this.idx - o.idx;
        }
        return this.free - o.free;
    }
}

class Solution {
    // TC: O(MlogN), SC: O(N+M)
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;

        PriorityQueue<Pair> available = new PriorityQueue<>(); 
        PriorityQueue<Tuple> unavailable = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            available.add(new Pair(servers[i], i));
        }

        int[] ans = new int[m];

        int i = 0;
        int t = 0;

        while(i < m){
            int task = tasks[i];
            t = Math.max(t, i);

            // Check for server that would be free
            while(!unavailable.isEmpty() && unavailable.peek().free <= t){
                Tuple rem = unavailable.poll();
                available.add(new Pair(rem.server, rem.idx));
            }

            // Check if servers are busy
            if(available.isEmpty()){
                t = unavailable.peek().free;
                while(!unavailable.isEmpty() && unavailable.peek().free <= t){
                    Tuple rem = unavailable.poll();
                    available.add(new Pair(rem.server, rem.idx));
                }
            }

            // Assign the server for current task
            Pair p = available.poll();
            ans[i] = p.idx;

            // Add the server to unavailabe as it will be executing the current task 
            unavailable.add(new Tuple(p.server, t + task, p.idx));

            i++;        
        }

        return ans;
    }
}

class Pair{
    int busStop;
    int busCount;

    public Pair(int _busStop, int _busCount){
        this.busStop = _busStop;
        this.busCount = _busCount;
    }
}

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int n = routes.length;

        // HashMap for the reverse mapping -> {busStops -> busNos}
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<routes[i].length; j++){
                int stop = routes[i][j];

                if(map.containsKey(stop) == false){
                    map.put(stop, new ArrayList<>());
                }
                map.get(stop).add(i);
            }
        }

        HashSet<Integer> visBusStop = new HashSet<>();
        HashSet<Integer> visBusNo = new HashSet<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(source, 0));
        visBusStop.add(source);

        while(!q.isEmpty()){
            Pair rem = q.poll();
            int busStop = rem.busStop;
            int busCount = rem.busCount;

            if(busStop == target){
                return busCount;
            }

            ArrayList<Integer> bus_nos = map.getOrDefault(busStop, new ArrayList<>());
            for(int busNo: bus_nos){
                // Get all the bus stops visited by this busNo
                if(!visBusNo.contains(busNo)){
                    visBusNo.add(busNo);

                    int[] busStops = routes[busNo];
                    for(int stp: busStops){
                        if(!visBusStop.contains(stp)){
                            visBusStop.add(stp);
                            q.add(new Pair(stp, busCount + 1));
                        }
                    }                
                }
            }
        }        

        return -1;
    }
}
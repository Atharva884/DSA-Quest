class Tuple implements Comparable<Tuple> {
    int processingTime;
    int idx;

    public Tuple(int _pt, int _idx) {
        this.processingTime = _pt;
        this.idx = _idx;
    }

    @Override
    public int compareTo(Tuple o) {
        if (this.processingTime == o.processingTime) {
            return this.idx - o.idx;
        }
        return this.processingTime - o.processingTime;
    }
}

class Solution {
    // TC: O(NlogN), SC: O(N)
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = tasks[i][0];  
            arr[i][1] = tasks[i][1];  
            arr[i][2] = i; 
        }

        Arrays.sort(arr, new Comparator<>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];  
            }
        });

        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        int curTime = arr[0][0]; 

        int[] ans = new int[n];
        int k = 0;

        int i = 0;

        while (i < n || !pq.isEmpty()) {

            while (i < n && arr[i][0] <= curTime) {
                pq.add(new Tuple(arr[i][1], arr[i][2]));
                i++;
            }

            if (pq.isEmpty()) {
                curTime = arr[i][0];
                continue;
            }

            Tuple rem = pq.poll();
            curTime += rem.processingTime;
            ans[k++] = rem.idx;
        }


        return ans;
    }
}

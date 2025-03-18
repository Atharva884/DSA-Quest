class Pair implements Comparable<Pair>{
    int val;
    int height;

    public Pair(int _val, int _height){
        this.val = _val;
        this.height = _height;
    }

    public int compareTo(Pair o){
        if(this.val == o.val){
            return this.height - o.height;
        }

        return this.val - o.val;
    }
}

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        List<List<Integer>> ans = new ArrayList<>();

        Pair[] arr = new Pair[2*n];

        int i = 0;
        for(int[] bldg: buildings){
            arr[i++] = new Pair(bldg[0], -bldg[2]);
            arr[i++] = new Pair(bldg[1], bldg[2]);
        }   

        Arrays.sort(arr);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);

        int prevHeight = 0;

        for(Pair p: arr){
            int x = p.val;
            int h = p.height;

            if(h < 0){
                // Start of bldg
                pq.add(-h);
            }else{
                // End of bldg
                pq.remove(h);
            }

            if(pq.peek() != prevHeight){
                List<Integer> temp = new ArrayList<>();
                temp.add(x);
                temp.add(pq.peek());

                ans.add(temp);
            }

            prevHeight = pq.peek();
        }


        return ans;
    }
}
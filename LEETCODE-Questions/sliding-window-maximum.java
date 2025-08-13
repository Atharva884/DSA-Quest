class Solution {
    public int[] brute(int[] nums, int k){
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int[] ans = new int[n - (k - 1)];
        int idx = 0;

        for(int i=0; i<k; i++){
            pq.add(nums[i]);
        }


        ans[idx++] = pq.peek();

        int sp = 0;
        int ep = k;

        while(ep < n){
            pq.add(nums[ep]);
            pq.remove(nums[sp]);

            ans[idx++] = pq.peek();

            sp++;
            ep++;
        }

        return ans;
    }

    public int[] optimal(int[] nums, int k){
        int n = nums.length;
        int[] res = new int[n - (k - 1)];
        int idx = 0;

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0; i<k; i++){
            while(!dq.isEmpty() && nums[i] > dq.getLast()){
                dq.removeLast();
            }
            dq.addLast(nums[i]);
        }

        res[idx++] = dq.getFirst();

        int sp = 0;
        int ep = k;

        while(ep < n){
            int next = nums[ep];
            int old = nums[sp];

            // Acquire the next element
            while(!dq.isEmpty() && next > dq.getLast()){
                dq.removeLast();
            }
            dq.addLast(next);

            // Release
            if(old == dq.getFirst()){
                dq.removeFirst();
            }

            res[idx++] = dq.getFirst();

            sp++;
            ep++;
        }

        return res;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // Brute Force Approach - TLE
        // TC: O(N * k), SC: O(k)
        // return brute(nums, k);

        // Optimal Approach
        // TC: O(N + N) ~ O(2N), SC: O(k)
        return optimal(nums, k);
    }
}

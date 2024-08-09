class Solution {
    // Brute Force Approach - { Medium }
    // TC: O(N^2) + O(N^2 log N^2) + O(N^2)
    // SC: O(N) + O(N^2)

    // public static int[] prefixSum(int[] nums, int n){
    //     int[] pfSum = new int[n];
    //     pfSum[0] = nums[0];

    //     for(int i=1; i<n; i++){
    //         pfSum[i] = pfSum[i-1] + nums[i];
    //     }

    //     return pfSum;
    // }

    // public static int rangeSum(int[] nums, int n, int left, int right) {
    //     ArrayList<Integer> arr = new ArrayList<>();

    //     int[] pfSum = prefixSum(nums, n);

    //     // Genrating Subarray
    //     for(int sp=0; sp<n; sp++){
    //         for(int ep=sp; ep<n; ep++){
    //             int sum = 0;
                
    //             if(sp == 0){
    //                 sum = pfSum[ep];
    //             }else{
    //                 sum = (pfSum[ep] - pfSum[sp-1]);
    //             }
    
    //             arr.add(sum);
    //         }
    //     }

    //     // Sort the ArrayList in the increasing order
    //     Collections.sort(arr);

    //     int sum = 0;
    //     for(int i=left-1; i<right; i++){
    //         sum = (sum + arr.get(i)) % 1000000007;
    //     }

    //     return sum;
    // }


    // Optimal Approach - { Hard }
    // TC: O(NlogN) + O(N^2 log N)
    // SC: O(N)

    static int MOD = (int) 1e9 + 7;

    public static int rangeSum(int[] nums, int n, int left, int right){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                // Min heap --> increasing order
                return a[0] - b[0];
            }
        });

        for(int i=0; i<n; i++){
            pq.offer(new int[]{nums[i], i});
        }

        // PQ: [{1,0}, {2,1}, {3, 2}, {4, 3}];
        // left = 1, right = 5

        int sum = 0;

        // 0, 1, 2, 3, 4

        // We are looping index from 0 bcoz we have to form correct subarrays and we are checking
        // if the index lies in the range of [left, right] then only we are adding into the sum 
        for(int index=1; index<=right; index++){
            int[] cur = pq.poll();  // {1,0}

            if(index >= left){
                sum = (sum + cur[0]) % MOD;
            }

            // Preparing for next
            if(cur[1] + 1 < n){
                cur[1]++;
                cur[0] += nums[cur[1]];
                pq.offer(cur);
            }
        }

        return sum;
    }
}
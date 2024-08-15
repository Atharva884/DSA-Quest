// TC: O(N^2) + O(NlogN), SC: O(N)

// class Solution {
//     public int smallestDistancePair(int[] nums, int k) {
//         int n = nums.length;
//         // Min heap
//         PriorityQueue<Integer> pq = new PriorityQueue<>();

//         for(int i=0; i<n; i++){
//             for(int j=i+1; j<n; j++){
//                 int diff = Math.abs(nums[j] - nums[i]);
//                 pq.add(diff);
//             }
//         }

//         int ans = -1;
//         while(k != 0){
//             ans = pq.poll();
//             k--;
//         }

//         return ans;
//     }
// }

class Solution {
    public int sliding(int mid, int[] arr, int n) {
        int j = 0;
        int count = 0;
        for (int i = 1; i < n; i++) { // doubt here
            while (arr[i] - arr[j] > mid) {
                j++;
            }
            count += i - j;
        }
        return count;
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int high = nums[n - 1] - nums[0];

        // int low = nums[1] - nums[0]; //check this later
        int low = Integer.MAX_VALUE;
        // This is loop is to handle testcase number 18/19 for duplicate entries min
        // will be 0 and not 1st index - 0th index.
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] < low)
                low = nums[i] - nums[i - 1];
        }

        while (low < high) {
            int mid = (low + high) / 2;

            int ans = sliding(mid, nums, n);
            if (ans < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
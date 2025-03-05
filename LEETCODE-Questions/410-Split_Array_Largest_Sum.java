class Solution {
    public int max(int[] arr){
        int max = Integer.MIN_VALUE;

        for(int num: arr){
            max = Math.max(num, max);
        }

        return max;
    }

    public int sum(int[] arr){
        int sum = 0;

        for(int num: arr){
            sum += num;
        }

        return sum;
    }

    public int cal(int[] arr, int cap){
        int n = arr.length;
        int k = 1;
        int sum = 0;

        for(int i=0; i<n; i++){
            if(sum + arr[i] > cap){
                k++;
                sum = 0;
            }

            sum += arr[i];
        }

        return k;
    }
    
    // TC: O(log(sum - max)) * N, SC: O(1)
    public int splitArray(int[] nums, int k) {
        int n = nums.length;

        int lo = max(nums);
        int hi = sum(nums);
        int ans = -1;

        while(lo <= hi){
            int m = lo + ((hi - lo) >> 1);

            int cnt = cal(nums, m);

            if(cnt <= k){
                ans = m;
                hi = m - 1;
            }else{
                lo = m + 1;
            }
        }

        return ans;
    }
}
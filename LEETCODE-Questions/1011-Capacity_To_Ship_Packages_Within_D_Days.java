class Solution {
    public int calculate(int[] arr, int cap){
        int days = 1;
        int sum = 0;

        for(int w: arr){
            if(sum + w > cap){
                days++;
                sum = 0;
            }

            sum += w;
        }

        return days;
    }

    // TC: O(log(max(arr) - sum(arr))) * O(N), SC: O(1)
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int max = 0;
        int sum = 0;

        for(int w: weights){
            max = Math.max(max, w); 
            sum += w;
        }

        int lo = max;
        int hi = sum;
        int ans =  0;

        while(lo <= hi){
            int m = lo + ((hi - lo) >> 1);

            int reqDays = calculate(weights, m);

            if(reqDays <= days){
                ans = m;
                hi = m - 1;
            }else{
                lo = m + 1;
            }
        }

        return ans;
    }
}
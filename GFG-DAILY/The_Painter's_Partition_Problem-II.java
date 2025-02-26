// User function Template for Java

class Solution {
    public int calculate(int[] arr, int cap){
        int workers = 1;
        int sum = 0;

        for(int w: arr){
            if(sum + w > cap){
                workers++;
                sum = 0;
            }

            sum += w;
        }

        return workers;
    }
    
    // TC: O(log(max(arr) - sum(arr))) * O(N), SC: O(1)
    public int minTime(int[] arr, int k) {
        int n = arr.length;
        int max = 0;
        int sum = 0;

        for(int w: arr){
            max = Math.max(max, w); 
            sum += w;
        }

        int lo = max;
        int hi = sum;
        int ans =  0;

        while(lo <= hi){
            int m = lo + ((hi - lo) >> 1);

            int reqWorkers = calculate(arr, m);

            if(reqWorkers <= k){
                ans = m;
                hi = m - 1;
            }else{
                lo = m + 1;
            }
        }

        return ans;
    }
}

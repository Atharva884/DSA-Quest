class Pair implements Comparable<Pair>{
    int w;
    int h;

    public Pair(int _w, int _h){
        this.w = _w;
        this.h = _h;
    }

    public int compareTo(Pair o){
        if(this.w == o.w){
            // Sort in descending order
            return o.h - this.h;
        }

        return this.w - o.w;
    }
}

class Solution {
    public int lengthOfLIS(Pair[] arr, int n){
        int[] dp = new int[n];

        int ans = 0;

        for(int i=0; i<n; i++){
            int lo = 0;
            int hi = ans;

            while(lo < hi){
                int m = lo + (hi - lo) / 2;

                if(arr[i].h > dp[m]){
                    lo = m + 1;
                }else{
                    hi = m;
                }
            }

            dp[lo] = arr[i].h;
            if(lo == ans){
                ans++;
            }
        }

        return ans;
    }

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;

        Pair[] arr = new Pair[n];
        for(int i=0; i<n; i++){
            arr[i] = new Pair(envelopes[i][0], envelopes[i][1]);
        }

        Arrays.sort(arr);

        // We need perform LIS on the height parameter
        return lengthOfLIS(arr, n);
    }
}
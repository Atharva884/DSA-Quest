class Solution {
    public int max(int[] arr){
        int max = Integer.MIN_VALUE;

        for(int num: arr){
            max = Math.max(num, max);
        }

        return max;
    }

    public long calBananas(int[] arr, long k){
        int n = arr.length;
        long banana = 0;

        for(int num: arr){
            long rem = num / k;
            if(num % k != 0){
                rem++;
            }

            banana += rem;
        }

        return banana;
    }

    // TC: O(log(max_pile)) * O(N), SC: O(1)
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        long lo = 1;
        long hi = max(piles);
        long ans = 0;

        while(lo <= hi){
            long m = lo + ((hi - lo) >> 1);

            long k = calBananas(piles, m); 

            if(k <= h){
                ans = m;
                hi = m - 1;
            }else{
                lo = m + 1;
            }
        }

        return (int) ans;
    }
}
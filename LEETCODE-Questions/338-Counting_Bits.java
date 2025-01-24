class Solution {
    // TC: O(N), SC: O(1)
    public int[] countBits(int n) {
        int[] res = new int[n+1];

        for(int i=0; i<n+1; i++){
            int cnt = 0;

            int x = i;
            while(x != 0){
                x = (x & (x-1));
                cnt++;
            }

            res[i] = cnt;
        }   

        return res;
    }
}
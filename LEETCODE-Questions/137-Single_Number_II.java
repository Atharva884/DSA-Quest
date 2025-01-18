class Solution {
    public boolean checkBit(int n, int i){
        if((n & (1 << i)) != 0) return true;

        return false;
    }

    // TC: O(32 * N) ~ O(N), SC: O(1)
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int res = 0;

        for(int i=0; i<=31; i++){

            int ans = 0;
            for(int j=0; j<n; j++){
                int num = nums[j];

                if(checkBit(num, i)){
                    ans++;
                }
            }

            if(ans % 3 != 0){
                res += (1 << i);
            }
        }

        return res;
    }
}
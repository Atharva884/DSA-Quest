class Solution {
    public int gcd(int a, int b){
        if(a == 0) return b;

        int temp = gcd(b % a, a);

        return temp;
    }

    // TC: O(N^2 * log(max(a, b))), SC: O(log(max(a, b)))
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for(int sp=0; sp<n; sp++){
            int ans = 0;
            for(int ep=sp; ep<n; ep++){
                ans = gcd(ans, nums[ep]);
                
                if(ans == k){
                    count++;
                }else if(ans < k) break;
            }
        }

        return count;
    }
}

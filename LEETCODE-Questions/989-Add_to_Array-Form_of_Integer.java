class Solution {
    // Optimal Approach
    // TC: O(N + K), SC: O(max(N,K)) --> We can neglect this as it is the output space
    public List<Integer> addToArrayForm(int[] nums, int k) {
        int n = nums.length;

        List<Integer> ans = new ArrayList<>();

        int carry = 0;
        int i = n-1;

        while(i >= 0 || k != 0){
            int sum = carry;

            if(i >= 0){
                sum += nums[i];
                i--;
            }

            if(k != 0){
                sum += k % 10;
                k = k / 10;
            }

            // Prep for next iteration
            carry = sum / 10;

            // Getting unit place digit
            sum = sum % 10;

            ans.add(sum);
        }

        if(carry != 0){
            ans.add(carry);
        }

        Collections.reverse(ans);

        return ans;
    }
}
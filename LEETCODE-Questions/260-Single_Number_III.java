class Solution {
    public boolean checkBit(int N, int i){
        if((N & (1 << i)) != 0) return true;
        
        return false;
    }

    // TC: O(N), SC: O(2)
    public int[] singleNumber(int[] nums) {
        int n = nums.length;

        int xor = 0;
        for(int num: nums){
            xor ^= num;
        }

        int idx = -1;
        for(int i=31; i>=0; i--){
            if(checkBit(xor, i)){
                idx = i;
                break;
            }
        }

        int set1 = 0;
        int set2 = 0;
        for(int i=0; i<n; i++){
            int num = nums[i];

            if(checkBit(num, idx)){
                // Set hai toh set1
                set1 = set1 ^ num;                
            }else{
                // UnSet hai toh set2
                set2 = set2 ^ num;   
            }
        }  

        int[] ans = new int[2];
        ans[0] = set1;
        ans[1] = set2;

        return ans;                    
    }
}
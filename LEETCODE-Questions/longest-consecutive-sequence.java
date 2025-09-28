class Solution {
    public boolean ls(int[] nums, int n, int x){
        for(int i=0; i<n; i++){
            if(nums[i] == x){
                return true;
            }
        }

        return false;
    }

    public int brute(int[] nums, int n){
        int longest = 0;

        int i = 0;
        while(i < n){
            int count = 1;
            int val = nums[i];
            while(ls(nums, n, val+1)){
                val = val + 1;
                count++;
            }
            i++;
            longest = Math.max(longest, count);
        }

        return longest;
    }

    public int better(int[] nums, int n){
        Arrays.sort(nums);
        int longest = 0;
        int lastSmaller = Integer.MIN_VALUE;
        int count = 0;

        for(int i=0; i<n; i++){
            if(nums[i]-1 == lastSmaller){
                count += 1;
            }else if(nums[i] != lastSmaller){
                count = 1;
            }
            lastSmaller = nums[i];
            longest = Math.max(longest, count);
        }

        return longest;
    }

    public int optimal(int[] nums, int n){
        HashSet<Integer> hs = new HashSet<>();
        for(int num: nums) hs.add(num);

        int longest = 0;

        for(int num: hs){
            if(hs.contains(num-1)) continue;

            int x = num;
            int count = 0;
            while(hs.contains(num)){
                num = num + 1;
                count++;
            }
            longest = Math.max(longest, count);
        }

        return longest;
    }

    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        // Brute Approach - TLE
        // TC: O(N*N) ~ O(N^2), SC: O(1)
        // return brute(nums, n);

        // Better Approach
        // TC: O(NlogN), SC: O(1)
        // return better(nums, n);
        
        // Optimal Approach
        // TC: O(N) + O(2N) ~ O(3N), SC: O(N)
        return optimal(nums, n);
    }
}

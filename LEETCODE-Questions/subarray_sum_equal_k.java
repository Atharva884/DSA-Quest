class Solution {
    public int brutest(int[] arr, int n, int k){
        int count = 0;

        for(int sp=0; sp<n; sp++){
            for(int ep=sp; ep<n; ep++){
                // We get [sp, ep] subarray
                int sum = 0;
                for(int i=sp; i<=ep; i++){
                    sum += arr[i];
                }

                if(sum == k) count++;
            }
        }

        return count;
    }

    public int brute(int[] arr, int n, int k){
        int count = 0;

        for(int sp=0; sp<n; sp++){
            int sum = 0;

            for(int ep=sp; ep<n; ep++){
                sum += arr[ep];

                if(sum == k) count++;
            }
        }

        return count;
    }

    public int[] prefixSum(int[] arr, int n){
        int[] pfSum = new int[n];
        pfSum[0] = arr[0];

        for(int i=1; i<n; i++){
            pfSum[i] = pfSum[i-1] + arr[i];
        }

        return pfSum;
    }

    public int better(int[] arr, int n, int k){
        int[] pfSum = prefixSum(arr, n);
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        map.put(0, 1);

        int ep = 0;
        while(ep < n){
            int num = pfSum[ep] - k;
            if(map.containsKey(num)){
                count += map.get(num);
            }
            map.put(pfSum[ep], map.getOrDefault(pfSum[ep], 0) + 1);
            ep++;
        }

        return count;
    }

    public int optimal(int[] arr, int n, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] pfSum = new int[n];
        int count = 0;

        pfSum[0] = arr[0];
        map.put(0, 1);

        int ep = 0;
        while(ep < n){
            if(ep != 0){
                pfSum[ep] = pfSum[ep-1] + arr[ep];
            }

            int num = pfSum[ep] - k;
            if(map.containsKey(num)){
                count += map.get(num);
            }
            map.put(pfSum[ep], map.getOrDefault(pfSum[ep], 0) + 1);
            ep++;
        }

        return count;
    }

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        // Brutest Approach --> It Gives TLE
        // TC: O(N^3), SC: O(1)
        // return brutest(nums, n, k);

        // Brute Approach
        // TC: O(N^2), SC: O(1)
        // return brute(nums, n, k);

        // Better Approach --> But Two passes
        // TC: O(N + N), SC: O(N)
        // return better(nums, n, k);

        // Optimal Approach --> One pass
        // TC: O(N), SC: O(N)
        return optimal(nums, n, k);
    }
}

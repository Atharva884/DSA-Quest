class Solution {
    public int subArraySumEquals0(int[] arr, int n, int k){
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
    
    public int brute(int[] arr, int n){
        int count = 0;
        
        for(int sp=0; sp<n; sp++){
            int sum = 0;
            for(int ep=sp; ep<n; ep++){
                sum += arr[ep];
                
                if(sum == 0) count++;
            }
        }
        
        return count;
    }
    
    public int findSubarray(int[] arr) {
        int n = arr.length; 
        
        // Brute Approach
        // TC: O(N^2), SC: O(1)
        // return brute(arr, n);
        
        // Optimal Approach
        // TC: O(N), SC: O(N)
        return subArraySumEquals0(arr, n, 0);
    }
}

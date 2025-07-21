class Solution {
    static int subArraySumEqualsk(int[] arr, int n, int k){
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
    
    static int[] prefixCount0(int[] arr){
        int n = arr.length;
        
        int[] pfCount = new int[n];
        if(arr[0] == 0){
            pfCount[0] = 1;
        }
        
        for(int i=1; i<n; i++){
            if(arr[i] == 0){
                pfCount[i] = pfCount[i-1] + 1;
            }else{
                pfCount[i] = pfCount[i-1];
            }
        }
        
        return pfCount;
    }
    
    static int[] prefixCount1(int[] arr){
        int n = arr.length;
        
        int[] pfCount = new int[n];
        if(arr[0] == 1){
            pfCount[0] = 1;
        }
        
        for(int i=1; i<n; i++){
            if(arr[i] == 1){
                pfCount[i] = pfCount[i-1] + 1;
            }else{
                pfCount[i] = pfCount[i-1];
            }
        }
        
        return pfCount;
    }
    
    
    static int subArraySumWithEquals0And1(int[] arr, int n){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int[] zeros = prefixCount0(arr);
        int[] ones = prefixCount1(arr);
        
        int count = 0; 
        
        int ep = 0;
        while(ep < n){
            int diff = zeros[ep] - ones[ep];
            if(map.containsKey(diff)){
                count += map.get(diff);
            }
            
            map.put(diff, map.getOrDefault(diff, 0) + 1);
                
            ep++;
        }
        
        return count;
    }
    
    static int countSubarrWithEqualZeroAndOne(int arr[], int n) {
        // Optimal (But Not Generic)
        // TC: O(N), SC: O(N)
        
        // for(int i=0; i<n; i++){
        //     if(arr[i] == 0) arr[i] = -1;
        // }
        
        // return subArraySumEqualsk(arr, n, 0);
        
        // Optimal (Generic -> We can solve more question with this same type)
        // TC: O(N), SC: O(N)
        
        return subArraySumWithEquals0And1(arr, n);
    }
}

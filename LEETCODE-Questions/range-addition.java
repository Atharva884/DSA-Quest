class Main {
    public static int[] prefixSum(int[] arr, int n){
        int[] pfSum = new int[n];
        pfSum[0] = arr[0];
        
        for(int i=1; i<n; i++){
            pfSum[i] = pfSum[i-1] + arr[i];
        }
        
        return pfSum;
    }
    
    public static int[] rangeAdd(int[] arr, int[][] updates){
        int len = arr.length;
        int n = updates.length;
        
        for(int i=0; i<n; i++){
            int sp = updates[i][0];
            int ep = updates[i][1];
            int val = updates[i][2];
            
            arr[sp] += val;
            if(ep + 1 < len){
                arr[ep+1] -= val;
            }
        }
        
        return prefixSum(arr, len);
    }
    
    public static void main(String[] args) {
        int len = 5;
        int[][] updates = {{1,3,2}, {2,4,3}, {0,2,-2}};
        
        int[] arr = new int[len];
        
        int[] ans = rangeAdd(arr, updates);
        
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
}

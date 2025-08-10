class Solution {
    public void brute(int[] arr){
        Arrays.sort(arr);
    }
    
    public void better(int[] arr){
        int n = arr.length;
        int[] temp = new int[3];
        
        for(int a: arr){
            temp[a]++;
        }
        
        int k = 0;
        for(int i=0; i<temp.length; i++){
            int num = temp[i];
            for(int idx=0; idx<num; idx++){
                arr[k++] = i;
            }
            
        }
    }
    
    public void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void optimal(int[] arr){
        int n = arr.length;
        
        int i = 0;
        int j = 0;
        int k = n-1;
        
        while(j <= k){
            int num = arr[j];
            
            if(num == 0){
                swap(i, j, arr);
                i++;
                j++;
            }else if(num == 1){
                j++;
            }else{
                swap(j, k, arr);
                k--;
            }
        }
        
    }
    
    public void sort012(int[] arr) {
        // Brute Approach
        // TC: O(NlogN), SC: O(1)
        // brute(arr);
        
        // Better Approach
        // TC: O(N + max) ~ O(N), SC: O(max) ~ max is 3 then O(1)
        // better(arr);
        
        // Optimal Approach
        // TC: O(N), SC: O(1)
        optimal(arr);
        
    }
}

class Solution {
    // Please change the array in-place
    public static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // TC: O(N^2), SC: O(1)
    public void insertionSort(int arr[]) {
        int n = arr.length;
        
        for(int i=1; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(arr[j] > arr[j+1]){
                    swap(j, j+1, arr);
                }else{
                    break;
                }
            }
        }
    }
}
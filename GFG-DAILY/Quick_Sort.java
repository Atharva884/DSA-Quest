// Quick Sort

// class Solution {
//     // TC: O(N^2) -> {Worst Case} & O(NlogN) -> {Best Case}, SC: O(N)
//     static void quickSort(int arr[], int low, int high) {
//         // We have nothing in the arr, or only one element i.e already sorted
//         if(low >= high) return;
        
        
//         int p = partition(arr, low, high);
        
//         quickSort(arr, low, p-1);
//         quickSort(arr, p+1, high);
//     }
    
//     static void swap(int i, int j, int[] arr){
//         int temp = arr[i];
//         arr[i] = arr[j];
//         arr[j] = temp;
//     }

//     static int partition(int arr[], int low, int high) {
//         int p1 = low + 1;
//         int p2 = high;
//         int k = arr[low];
        
//         while(p1 <= p2){
//             if(arr[p1] <= k){
//                 p1++;
//             }else if(arr[p2] > k){
//                 p2--;
//             }else{
//                 swap(p1, p2, arr);
//                 p1++;
//                 p2--;
//             }
//         }
        
//         swap(low, p2, arr);
        
//         return p2;
//     }
// }

// Randomized Quick Sort
// We can say that this O(NlogN) but we can't gurantee

class Solution {
    static Random r = new Random();
    
    // TC: O(N^2) -> {Worst Case} & O(NlogN) -> {Best Case}, SC: O(N)
    static void quickSort(int arr[], int low, int high) {
        // We have nothing in the arr, or only one element i.e already sorted
        if(low >= high) return;
        
        int p = partition(arr, low, high);
        
        quickSort(arr, low, p-1);
        quickSort(arr, p+1, high);
    }
    
    static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int arr[], int low, int high) {
        int m = low + r.nextInt(high - low + 1);
        
        // Its needed, as we select random index from [s - e], and swap the index
        // bcoz, we are dealing with array
        swap(low, m, arr);
        
        int p1 = low + 1;
        int p2 = high;
        int k = arr[low];
        
        while(p1 <= p2){
            if(arr[p1] <= k){
                p1++;
            }else if(arr[p2] > k){
                p2--;
            }else{
                swap(p1, p2, arr);
                p1++;
                p2--;
            }
        }
        
        swap(low, p2, arr);
        
        return p2;
    }
}
class Solution {
    public static void mergeTwoSortedArr(int[] arr, int s, int m, int e){
        int[] ans = new int[e - s + 1];
        int k = 0;
        int i = s;
        int j = m+1;

        while(i <= m && j <= e){
            if(arr[i] < arr[j]){
                ans[k++] = arr[i++];
            }else{
                ans[k++] = arr[j++];
            }
        }
        while(i <= m){
            ans[k++] = arr[i++];
        }
        while(j <= e){
            ans[k++] = arr[j++];
        }
        
        for(int l=s; l<=e; l++){
            arr[l] = ans[l - s];
        }
    }

    void merge(int[] arr, int l, int r, int n){
        if(l == r) return;
        
        int m = l + ((r - l) >> 1);
        
        merge(arr, l, m, n);
        merge(arr, m+1, r, n);
        
        mergeTwoSortedArr(arr, l, m, r);
    }

    // TC: O(NlogN), SC: O(N)
    void mergeSort(int arr[], int l, int r) {
        int n = arr.length;
        
        merge(arr, l, r, n);
    }
}

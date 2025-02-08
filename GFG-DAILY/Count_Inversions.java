// User function Template for Java

class Solution {
    static int count;
    
    static void mergeTwoSortedArr(int[] arr, int l, int m, int h){
        int[] ans = new int[h - l + 1];
        
        int i = l;
        int j = m+1;
        int k = 0;
        
        while(i <= m && j <= h){
            if(arr[i] <= arr[j]){
                ans[k++] = arr[i++];
            }else{
                count += (m-i+1);
                ans[k++] = arr[j++];
            }
        }
        
        while(i <= m){
            ans[k++] = arr[i++];
        }
        
        while(j <= h){
            ans[k++] = arr[j++];
        }
        
        for(int p=l; p<=h; p++){
            arr[p] = ans[p - l];
        }
    }
    
    static void merge(int[] arr, int l, int h){
        if(l == h) return;
        
        int m = l + ((h - l) >> 1);
        
        merge(arr, l, m);
        merge(arr, m+1, h);
        
        mergeTwoSortedArr(arr, l, m, h);
    }
    
    // TC: O(NlogN), SC: O(N)
    static int inversionCount(int arr[]) {
        int n = arr.length;
        int l = 0;
        int h = n-1;
        
        count = 0;
        
        merge(arr, l, h);
        
        return count;
    }
}
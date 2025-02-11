import java.util.* ;
import java.io.*; 

public class Solution {
	public static void swap(int i, int j, int[] arr){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

  // TC: O(N), SC: O(1)
	public static int[] wiggleSort(int n, int[] arr) {

		for(int i=0; i<n-1; i++){
			if((i & 1) == 0){
				// Even Case
				if(arr[i] > arr[i+1]){
					swap(i, i+1, arr);
				}
			}else{
				// Odd Case
				if(arr[i] < arr[i+1]){
					swap(i, i+1, arr);
				}
			}
		}

		return arr;
	}
}

import java.util.* ;
import java.io.*; 


public class Solution {
	public static void swap(int i, int j, int[] arr){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
  
  // TC: O(N^2), SC: O(1)
	public static void selectionSort(int arr[], int n) {
		
		for(int i=0; i<n; i++){
			int minElem = arr[i];
			int minIdx = i;

			for(int j=i+1; j<n; j++){
				if(arr[j] <= minElem){
					minElem = arr[j];
					minIdx = j;
				}
			}

			swap(i, minIdx, arr);
		}
	}
}

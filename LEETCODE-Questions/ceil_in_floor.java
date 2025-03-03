import java.util.* ;
import java.io.*; 

public class Solution {
    // TC: O(logN), SC: O(1)
    public static int[] getFloorAndCeil(int[] a, int n, int x) {
      int lo = 0;
      int hi = n-1;

      int floor = -1;
      int ceil = -1;

      while(lo <= hi){
        int m = lo + ((hi - lo) >> 1);

        if(a[m] == x){
          return new int[]{x, x};
        }else if(a[m] > x){
          ceil = a[m];
          hi = m - 1;
        }else{
          floor = a[m];
          lo = m + 1;
        }
      }

      return new int[]{floor, ceil};
    }
}

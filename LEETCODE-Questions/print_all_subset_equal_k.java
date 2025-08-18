import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class TestClass {
    public static void solve(int[] arr, int i, int n, int k, int sum, ArrayList<Integer> list){
        if(i == n){
            if(sum == k){
                for(int num: list){
                    System.out.print(num + " ");
                }
                System.out.println();
            }
            return;
        }

        if(sum + arr[i] <= k){
            list.add(arr[i]);
            solve(arr, i+1, n, k, sum + arr[i], list);
            list.remove(list.size() - 1);
        }
        solve(arr, i+1, n, k, sum, list);
    }

    public static void main(String args[] ) throws Exception {
        // //BufferedReader
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        solve(arr, 0, n, k, 0, list);
    }
}

public class Main {
    public static int brute(int[] arr, int n){
        int count = 0;
    
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[j] - arr[i] == j - i) count++;
            }
        }
        
        return count;
    }
    
    public static int optimal(int[] arr, int n){
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int count = 0;
        for(int i=0; i<n; i++){
            int diff = arr[i] - i;
            if(map.containsKey(diff)){
                count+=map.get(diff);
            }
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        
        return count;
    }

    public static void main(String[] args) {
        // Same Differences -> CF 719
        // condn: aj - ai = j - i

        Scanner scn = new Scanner(System.in);
        int[] arr = {1, 6, 3, 4, 5, 6};
        int n = arr.length;

        
        // Brute Approach
        // TC: O(N^2), SC: O(1)
        // int ans = brute(arr, n);
        // System.out.println(ans);

        // Optimal Approach
        // TC: O(N), SC: O(N)
        int ans = optimal(arr, n);
        System.out.println(ans);
    }
}

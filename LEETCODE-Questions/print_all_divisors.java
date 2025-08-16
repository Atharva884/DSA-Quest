class Solution {
    public static void brute(int n){
        for(int i=1; i<=n; i++){
            if(n % i == 0){
                System.out.print(i + " ");
            }
        }
    }
    
    public static void optimal(int n){
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=1; i<=n/i; i++){
            if(n % i == 0){
                if(n/i == i){
                    arr.add(i);
                }else{
                    arr.add(i);
                    arr.add(n/i);
                }
            }
        }
        Collections.sort(arr);
        
        for(int num: arr){
            System.out.print(num + " ");
        }
    }
    
    public static void print_divisors(int n) {
        // Brute Approach - TLE
        // TC: O(N), SC: O(1)
        // brute(n);
        
        // Optimal Approach
        // TC: O(sqrt(N)), SC: O(sqrt(N))
        optimal(n);
    }
}

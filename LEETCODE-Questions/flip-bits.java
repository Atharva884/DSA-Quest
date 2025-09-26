// User function Template for Java

class Solution {

    // Optimal Approach
    // TC: O(N + N) ~ O(N), SC: O(1)
    public static int maxOnes(int a[], int n) {
        
        int countOfOnes = 0;
        for(int i=0; i<n; i++){
            if(a[i] == 0){
                a[i] = 1;
            }else{
                a[i] = -1;
                countOfOnes++;
            }
        }
        
        int sum = 0;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++){
            if(sum >= 0){
                sum += a[i];
            }else{
                sum = a[i];
            }
            max = Math.max(sum, max);
        }

        if(max > 0){
            return max + countOfOnes;
        }
        
        return countOfOnes;
    }
}

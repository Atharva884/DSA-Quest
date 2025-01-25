public class Solution {
    // Brute Force
    // TC: O(N), SC: O(N)

    // public static int[] findMissingRepeatingNumbers(int[] a) {
    //     int n = a.length;
    //     int[] ans = new int[2];

    //     int[] freq = new int[n+1];

    //     for(int i=0; i<n; i++){
    //         int num = a[i];

    //         freq[num]++;
            
    //         if(freq[num] > 1){
    //             ans[0] = num; 
    //         }
    //     }

    //     for(int i=1; i<=n; i++){
    //         if(freq[i] == 0){
    //             ans[1] = i; 
    //         }
    //     }

    //     return ans;
    // }

    // Optimal Approach -> Maths Intution
    // TC: O(N), SC: O(1)
    // public static int[] findMissingRepeatingNumbers(int[] a) {
    //     long n = a.length;

    //     long Sn = (n * (n + 1)) / 2;
    //     long S2n = (n * (n+1) * (2*n+1)) / 6;

    //     long s = 0;
    //     long s2 = 0;

    //     for(int i=0; i<n; i++){
    //         s += a[i];
    //         s2 += (long) a[i] * a[i];
    //     }    

    //     long eq1 = s - Sn;
    //     long eq2 = s2 - S2n;

    //     eq2 = eq2 / eq1;

    //     long x = (eq1 + eq2) / 2;
    //     long y = x - eq1;

    //     return new int[]{(int) x, (int) y};        
    // }


    // Optimal Approach -> Bit Manipulation
    // TC: O(N), SC: O(1)
    public static int[] findMissingRepeatingNumbers(int[] a) {
        int n = a.length;

        int xor = 0;
        for(int i=0; i<n; i++){
            xor ^= a[i];
            xor ^= (i+1);
        }

        // Finding position
        int idx = -1;
        for(int i=31; i>=0; i--){
            if((xor & (1 << i)) != 0){
                idx = i;
                break;
            }
        }

        int set1 = 0;  // set bit
        int set2 = 0;  // unset bit

        for (int i = 0; i < n; i++) {
            // Check in arr for segregation
            if((a[i] & (1 << idx)) != 0){
                set1 ^= a[i];
            }else{
                set2 ^= a[i];
            }

            // Check in range for segregation
            if((i + 1 & (1 << idx)) != 0){
                set1 ^= i+1;
            }else{
                set2 ^= i+1;
            }
        }

        for(int i=0; i<n; i++){
            if(a[i] == set2){
                return new int[]{set2, set1};
            }
        }

        return new int[]{set1, set2};
    }
}

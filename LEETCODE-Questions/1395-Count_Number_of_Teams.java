class Solution {
    // TC: O(N^3), SC: O(1)

    // public int numTeams(int[] arr) {
    //     int n = arr.length;
    //     int count = 0;
        
    //     for(int i=0; i<n; i++){
    //         for(int j=i+1; j<n; j++){
    //             for(int k=j+1; k<n; k++){
    //                 if((arr[i] < arr[j] && arr[j] < arr[k]) || (arr[i] > arr[j] && arr[j] > arr[k])){
    //                     count++;
    //                 }
    //             }
    //         }
    //     }
        
    //     // System.out.println(count);
        
    //     return count;
    // }

    public int numTeams(int[] rating){
        int n = rating.length;
    
        // Cond-1 arrays: left numbers smaller, right numbers larger
        int[] lessThanLeft = new int[n];
        int[] greaterThanRight = new int[n];
        
        // Cond-2 arrays: left numbers greater, right numbers smaller
        int[] greaterThanLeft = new int[n];
        int[] lessThanRight = new int[n];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    lessThanLeft[i]++;
                } else {
                    greaterThanLeft[i]++;
                }
            }
            for (int j = i + 1; j < n; j++) {
                if (rating[j] < rating[i]) {
                    lessThanRight[i]++;
                } else {
                    greaterThanRight[i]++;
                }
            }

            count += lessThanLeft[i] * greaterThanRight[i];
            count += greaterThanLeft[i] * lessThanRight[i];
        }
        
        return count;
    }
}
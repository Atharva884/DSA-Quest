class Solution {
    
    public int brute(int[] seats){
        int n = seats.length;

        int val1 = -1;
        int val2 = -1;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(seats[i] == 1 && val1 == -1){
                val1 = i;

                // It's for leading zeroes check
                max = Math.max(max, val1);  
                continue;
            }else if(seats[i] == 1 && val2 == -1){    // Middle gap checks
                val2 = i;
            }else if(seats[i] == 1){
                val1 = val2;
                val2 = i;
            }

            max = Math.max(max, (val2 - val1) / 2);
        }

        // Trailing zeroes checks

        // If only one 1 encounter
        if(val2 == -1){
            return Math.max(val1, (n-1)-val1);
        }

        // If multiple 1 encounter
        if(val2 != -1){
            return Math.max(max, (n-1)-val2);
        }

        return max;
    }

    public int maxDistToClosest(int[] seats) {
        // Brute Approach
        // Store the mappings of the person in the array of hashmap, and iterate
        // through the array and find the nearest left person and nearest right
        // person and take the max distance between them for that specific
        // index. Handle seperately for leading and trailing zeroes

        // Optimal Approach
        // TC: O(N), SC: O(1)
        return brute(seats);
    }
}

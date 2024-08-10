class Solution {
    public int minimumPushes(String word) {
        // We can use arr instead of hashmap to store the freq of the 
        // characters. (Bcoz, we have only 26 characters)
        int[] arr = new int[26];
        for(Character c: word.toCharArray()){
            // If b is the character and ASCI value of b is 98 and 
            // If we subtract with a which is 97 => 1 -> {Index value}
            arr[c - 'a']++;
        }

        // Why sorting?
        // As we know, we need to find the minimum no of pushes then we
        // need to assign the place(1,2,3,4) to the lowest freq character  
        // in our word string.
        Arrays.sort(arr); // It will sort in increasing order

        int minPushes = 0;
        int count = 0;

        // looping through max freq
        for(int i=25; i>=0; i--){
            // int mul = 0;

            // if(count < 8){
            //     mul = 1;
            // }else if(count < 16){
            //     mul = 2;
            // }else if(count < 24){
            //     mul = 3;
            // }else{
            //     mul = 4;
            // }

            if(arr[i] == 0) break;

            int val = arr[i] * (count/8 + 1);
            minPushes += val;
            count++;
        }

        return minPushes;

    }
}

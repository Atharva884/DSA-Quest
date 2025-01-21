class Solution {
    public int checkBit(int N, int i){
        if((N & (1 << i)) != 0) return 1;

        return 0;
    }

    public int minBitFlips(int start, int goal) {        
        int steps = 0;

        for(int i=31; i>=0; i--){
            if(checkBit(start, i) != checkBit(goal, i)){
                steps++;
            }
        }

        return steps;
    }
}
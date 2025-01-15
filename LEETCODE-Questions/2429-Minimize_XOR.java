class Solution {
    public int minimizeXor(int num1, int num2) {
        //find set bits in num2
        int setBits = Integer.bitCount(num2); //n & n-1 logN
        int bit=31; //signifies postion. 31 is MSB and 0 is LSB
        int res=0;
        while(bit>=0 && setBits>0){
            //start from MSB go down to LSB (31 se lekar 0 tak jaao)
            //check if bit is set in num1 and if so, set the bit in res
            if((num1 & (1 << bit)) !=0){
                res = res | (1 << bit); //when performing bit manipulation normal 0 will be treated as 000000 (32 bits), eventuatly converting our res into the answer we need.
                setBits--;
            }
            bit--;
        }
        bit = 0;
        // 1011001

        while(setBits>0 && bit<=32){
            if((num1 & (1 << bit)) == 0){ //checkls if num1's bit at  bit postion is 0. If it is 0 then set it to 1.
                res = res | (1 << bit);//RHS will always be 1. res will be the old res.
                //above line will set the bit at bit position to 1 for sure.
                setBits--;
            }
            bit++;
        }
        return res;
    }
}

/* Problem understood with kush using chatgpt on 16/01/25
*/
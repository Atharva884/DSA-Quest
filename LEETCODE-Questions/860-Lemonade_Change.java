class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int Five = 0;
        int Ten = 0;
        int Twenty = 0;

        // Note: Each lemon cost 5$
        for(int i=0; i<n; i++){
            // Customer is taking lemonade by giving exact amount.
            // No need to give change
            if(bills[i] == 5){
                Five++;
            }else if(bills[i] == 10){
                // Decrement 5 and increased 10 by 1 as we have give 5 to the 
                // customer and 10 has been received
                if(Five >= 1){
                    Five--;
                    Ten++;
                }else{
                    return false;
                }
            }else if(bills[i] == 20){
                // There will be Twenty Note
                if(Ten >= 1 && Five >= 1){
                    Ten--;
                    Five--;
                    Twenty++;
                }else if(Five >= 3){
                    Five = Five - 3;;
                    Twenty++;
                }else{
                    return false;
                }
            }
        }


        return true;
    }
}
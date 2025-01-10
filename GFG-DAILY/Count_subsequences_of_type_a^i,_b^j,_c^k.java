//User function Template for Java

class Solution
{
    static int MOD = (int) (1e9) + 7;
    // TC: O(N), SC: O(1)
    public int fun(String s){
        int n = s.length();
        
        long ea = 0;
        long eb = 0;
        long ec = 0;
        
        for(char c: s.toCharArray()){
            if(c == 'a'){
                ea = (2 * ea + 1) % MOD;
            }else if(c == 'b'){
                eb = (2 * eb + ea) % MOD;
            }else{
                ec = (2 * ec + eb) % MOD;
            }
        }
        
        return (int) ec;
    }
}
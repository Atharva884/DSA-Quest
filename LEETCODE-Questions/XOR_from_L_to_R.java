class Solution {
    // Pattern (Yeh tuzhe kabhi nhi aayega interview mai 🙌😫)
    
    // 1  1^0                -> 1
    // 2  1^2                -> 3
    // 3  1^2^3              -> 0
    // 4  1^2^3^4            -> 4
        
    // 5  1^2^3^4^5          -> 1
    // 6  1^2^3^4^5^6        -> 7
    // 7  1^2^3^4^5^6^7      -> 0
    // 8  1^2^3^4^5^6^7^8    -> 8 
    
    // TC: O(1)
    public static int getXorFrom1ToN(int n) {
        if (n % 4 == 1) return 1;
        else if (n % 4 == 2) return n+1;
        else if (n % 4 == 3) return 0;
        else return n; 
    }
    
    public static int findXOR(int l, int r) {
        return getXorFrom1ToN(l-1) ^ getXorFrom1ToN(r);
    }
}

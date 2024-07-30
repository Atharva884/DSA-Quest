class Solution {
    public static boolean isPalindromeHelper(char[] arr, int s, int e){
        if(s == e || s > e){
            return true;
        }
        
        if(arr[s] == arr[e]){
            boolean temp = isPalindromeHelper(arr, s+1, e-1);
            return temp;
        }else{
            return false;
        }
    }

    public boolean isPalindrome(int x) {
        char[] arr = String.valueOf(x).toCharArray();
        boolean ans = isPalindromeHelper(arr, 0, arr.length - 1);

        return ans;
    }
}
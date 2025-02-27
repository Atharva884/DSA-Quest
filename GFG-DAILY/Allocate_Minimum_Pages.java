//Back-end complete function Template for Java

class Solution {
    public static int cal(int[] arr, int cap){
        int stud = 1;
        int sum = 0;
        
        for(int val: arr){
            if(sum + val > cap){
                stud++;
                sum = 0;
            }
            
            sum += val;
        }
        
        return stud;
    }
    
    // TC: O(log(max(arr) - sum(arr))) * O(N), SC: O(1)
    public static int findPages(int[] arr, int k) {
        int n = arr.length;
        
        if(n < k) return -1;
        
        int sum = 0;
        int max = Integer.MIN_VALUE;
        
        for(int val: arr){
            max = Math.max(max, val);
            sum += val;
        }
        
        int lo = max;
        int hi = sum;
        int ans = 0;
        
        while(lo <= hi){
            int m = lo + ((hi - lo) >> 1);
            
            int stud = cal(arr, m);
            
            if(stud <= k){
                ans = m;
                hi = m - 1;
            }else{
                lo = m + 1;
            }
        }
        
        return ans;
    }
}

class Solution {
    public static int[] nseOnRight(int[] arr, int n){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans, n);

        int i=0;
        while(i < n){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
                int idx = st.pop();
                ans[idx] = i;
            }
            
            st.push(i);
            i++;
        }
        
        return ans;
    }
    
    public static int[] nseOnLeft(int[] arr, int n){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        int i=n-1;
        while(i >= 0){
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
                int idx = st.pop();
                ans[idx] = i;
            }
            
            st.push(i);
            i--;
        }
        
        return ans;
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = (int) 1000000007;

        int[] nseRight = nseOnRight(arr, n);
        int[] nseLeft = nseOnLeft(arr, n);

        long sum = 0;

        for(int i=0; i<n; i++){
            int right = nseRight[i] - i;
            int left = i - nseLeft[i];

            sum = (sum + ( (long) right * left % MOD) * arr[i] % MOD) % MOD; 
        }
        
        return (int) sum;
    }
}
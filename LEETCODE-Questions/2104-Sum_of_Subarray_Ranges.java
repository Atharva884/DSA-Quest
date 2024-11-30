class Solution {
    // First Two utility function for finding Subarray minimum
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

    // First Two utility function for finding Subarray maximum
    public static int[] ngeOnRight(int[] arr, int n){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans, n);

        int i=0;
        while(i < n){
            while(!st.isEmpty() && arr[i] > arr[st.peek()]){
                int idx = st.pop();
                ans[idx] = i;
            }
            
            st.push(i);
            i++;
        }
        
        return ans;
    }
    
    public static int[] ngeOnLeft(int[] arr, int n){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        int i=n-1;
        while(i >= 0){
            while(!st.isEmpty() && arr[i] >= arr[st.peek()]){
                int idx = st.pop();
                ans[idx] = i;
            }
            
            st.push(i);
            i--;
        }
        
        return ans;
    }

    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        int[] nseRight = nseOnRight(nums, n); 
        int[] nseLeft = nseOnLeft(nums, n); 
        int[] ngeRight = ngeOnRight(nums, n); 
        int[] ngeLeft = ngeOnLeft(nums, n); 

        long minSum = 0;
        long maxSum = 0;

        for(int i=0; i<n; i++){
            long leftMin = i - nseLeft[i];
            long rightMin = nseRight[i] - i;

            long leftMax = i - ngeLeft[i];
            long rightMax = ngeRight[i] - i;

            minSum += leftMin * rightMin * nums[i];
            maxSum += leftMax * rightMax * nums[i];
        }

        return maxSum - minSum;
    }
}
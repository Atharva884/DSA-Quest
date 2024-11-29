//User function Template for Java

class Solution {
	public static int[] help_classmate(int arr[], int n) 
	{ 
	    int[] ans = new int[n];
	    Arrays.fill(ans, -1);
	    
	    Stack<Integer> st = new Stack<>();
	    
	    for(int i=0; i<n; i++){
	        while(!st.isEmpty() && arr[i] < arr[st.peek()]){
	            int idx = st.pop();
	            ans[idx] = arr[i]; 
	        }
	        
	        st.push(i);
	    }
	    
	    return ans;
	} 
}

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
      
        for(int i=0; i<n; i++){
            int asteroid = asteroids[i];

            // If the asteroid is moving to left
            if(asteroid < 0){
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroid)){
                    st.pop();
                }

                // Check for same size asteroid
                if(!st.isEmpty() && st.peek() == Math.abs(asteroid)){
                    st.pop();
                }else if(st.isEmpty() || st.peek() < 0){ 
                    // Insert, if st is empty i.e there are no asteroid moving in right and if the
                    // top element on the stack is less than 0 means the asteroid is moving in left dir
                    st.push(asteroid);
                }
            }else{
                // If the asteroid is moving to right
                st.push(asteroid);
            }
        }
         
        int[] arr = new int[st.size()];
        int idx = st.size() - 1;

        while(!st.isEmpty()){
            arr[idx--] = st.pop();
        }
        
        return arr;
    }
}
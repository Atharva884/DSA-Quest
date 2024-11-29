class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            int asteroid = asteroids[i];

            if(st.isEmpty()){
                st.push(asteroid);
                continue;
            }

            if(asteroid < 0){
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < -asteroid){
                    st.pop();
                }

                if(!st.isEmpty() && st.peek() == -asteroid){
                    st.pop();
                }else if(st.isEmpty() || st.peek() < 0){
                    st.push(asteroid);
                }
            }else{
                st.push(asteroid);
            }

        }

        int[] ans = new int[st.size()];
        for(int i=ans.length - 1; i>=0; i--){
            ans[i] = st.pop();
        }
       
        return ans;
    }
}
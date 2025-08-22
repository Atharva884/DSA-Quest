class solve {
    static boolean checkBit(int n, int i){
        return (n & (1 << i)) != 0;
    }

    static ArrayList<String> brute(int n){
        ArrayList<String> ans = new ArrayList<>();
        
        for(int i=1; i<=n; i++){
            StringBuilder sb = new StringBuilder();
            boolean started = false;  // to skip leading zeros
            
            for(int j=31; j>=0; j--){
                if(checkBit(i, j)){
                    sb.append("1");
                    started = true;
                } else if(started) {
                    sb.append("0");
                }
            }
            
            ans.add(sb.toString());
        }
        
        return ans;
    }

    
    static ArrayList<String> optimal(int n){
        ArrayList<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add("1");
        
        for(int i=1; i<=n; i++){
            String rem = q.poll();
            
            ans.add(rem);
            
            q.add(rem + '0');
            q.add(rem + '1');
        }
        
        return ans;
    }
    
    static ArrayList<String> generate(int n) {
        // Brute Approach - TLE
        // TC: O(N*32), SC: O(NlogK)
        // return brute(n);
        
        // Optimal Approach
        // TC: O(NlogK) where k is the length of the string, SC: O(NlogK)
        return optimal(n);
    }
}

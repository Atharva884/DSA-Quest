class Solution {
    public int brute(String s, int k){
        int n = s.length();
        int min = Integer.MAX_VALUE;

        for(int sp=0; sp <= n - k; sp++){
            int count = 0;
            for(int ep=sp; ep < sp + k; ep++){
                char c = s.charAt(ep);
                if(c == 'W') count++;
            }

            min = Math.min(min, count);
        }

        return min;
    }

    public int optimal(String s, int k){
        int n = s.length();
        int ans = Integer.MAX_VALUE;

        int count = 0;
        for(int i=0; i<k; i++){
            if(s.charAt(i) == 'W') count++;
        }
        ans = Math.min(ans, count);

        int sp = 0;
        int ep = k;

        while(ep < n){
            if(s.charAt(ep) == 'W') count++;
            if(s.charAt(sp) == 'W') count--;

            ans = Math.min(ans, count);

            sp++;
            ep++;
        }

        return ans;
    }

    public int minimumRecolors(String blocks, int k) {
        // Brute Approach
        // TC: O(N * K), SC: O(1)
        // return brute(blocks, k);

        // Optimal Approach
        // TC: O(N), SC: O(1)
        return optimal(blocks, k);
    }
}

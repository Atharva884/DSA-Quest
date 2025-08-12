class Solution {
    public int brute(String s){
        int n = s.length();
        int count = 0;

        for(int sp=0; sp<n; sp++){
            HashSet<Character> hs = new HashSet<>();
            for(int ep=sp; ep<n; ep++){
                char c = s.charAt(ep);
                hs.add(c);

                if(hs.size() >= 3){
                    count++;
                }
            }
        }

        return count;
    }

    public int better(String s){
        int n = s.length();
        int count = 0;

        for(int sp=0; sp<n; sp++){
            HashSet<Character> hs = new HashSet<>();
            for(int ep=sp; ep<n; ep++){
                char c = s.charAt(ep);
                hs.add(c);

                if(hs.size() == 3){
                    count += n - ep;
                    break;
                }
            }
        }

        return count;
    }

    public int optimal(String s){
        int n = s.length();

        int a = -1;
        int b = -1;
        int c = -1;
        int min = Integer.MAX_VALUE;
        int count = 0;

        for(int i=0; i<n; i++){
            char cr = s.charAt(i);

            if(cr == 'a'){
                a = i;
            }else if(cr == 'b'){
                b = i;
            }else{
                c = i;
            }
            min = Math.min(a, Math.min(b, c));

            if(min != -1){
                count += min + 1;
            }
        }   

        return count;
    }

    public int numberOfSubstrings(String s) {
        // Brute Approach - TLE 
        // TC: O(N^2), SC: O(1)
        // return brute(s);

        // Better Approach -- Small Optimization
        // TC: O(N^2), SC: O(1)
        // return better(s);

        // Optimal Approach
        // TC: O(N), SC: O(1)
        return optimal(s);
    }
}

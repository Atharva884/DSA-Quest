class Solution {
    public List<String> brute(String s){
        int n = s.length();

        HashSet<String> temp = new HashSet<>();
        HashSet<String> hs = new HashSet<>();

        for(int sp=0; sp<=n-10; sp++){
            StringBuilder sb = new StringBuilder();
            for(int ep=sp; ep<sp+10; ep++){
                sb.append(s.charAt(ep));
            }

            if(hs.contains(sb.toString())){
                temp.add(sb.toString());
            }

            hs.add(sb.toString());
        }

        return new ArrayList<String>(temp);
    }

    public List<String> optimal(String s){
        int n = s.length();

        HashSet<String> temp = new HashSet<>();
        HashSet<String> hs = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<10 && i<n; i++){
            sb.append(s.charAt(i));
        }

        hs.add(sb.toString());

        int ep = 10;
        while(ep < n){
            sb.deleteCharAt(0);
            sb.append(s.charAt(ep));

            if(hs.contains(sb.toString())){
                temp.add(sb.toString());
            }
            hs.add(sb.toString());

            ep++;
        }

        return new ArrayList<String>(temp);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();

        // Brute Approach
        // TC: O((N * 10), SC: O(N)
        // return brute(s);

        // Optimal Approach
        // TC: O(N), SC: O(N)
        return optimal(s);
    }
}

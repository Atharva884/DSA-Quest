class Solution {
    public int gcd(int a, int b){
        if(a == 0) return b;

        int temp = gcd(b % a, a);

        return temp;
    }

    // Optimal Approach
    // TC: O(2N * log(max(a, b))), SC: O(N + log(max(a, b)))
    public boolean hasGroupsSizeX(int[] deck) {
        int n = deck.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: deck){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int grp = 0;
        for(int key: map.keySet()){
            grp = gcd(map.get(key), grp);
        }

        if(grp > 1) return true;
        return false;
    }
}

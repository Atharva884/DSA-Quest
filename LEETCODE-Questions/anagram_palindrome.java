class Sol {
    int isPossible(String S) {
        int n = S.length();
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: S.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int odd = 0;
        for(char key: map.keySet()){
            if(map.get(key) % 2 != 0){
                odd++;
            }
        }
        
        return odd > 1 ? 0 : 1;
    }
}

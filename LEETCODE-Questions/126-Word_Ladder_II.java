class Solution {
    public void dfs(String word, String beginWord, List<String> seq, List<List<String>> ans, HashMap<String, Integer> map){
        // Reached target
        if(word.equals(beginWord)){
            List<String> path = new ArrayList<>(seq);
            Collections.reverse(path);
            ans.add(path);
            return;
        } 

        int lvls = map.get(word);
        for(int j=0; j<word.length(); j++){
            for(char c='a'; c<='z'; c++){
                char[] arr = word.toCharArray();
                arr[j] = c;
                String str = new String(arr);

                if (str.equals(beginWord) || (map.containsKey(str) && map.get(str) == lvls - 1)) {
                    seq.add(str);
                    dfs(str, beginWord, seq, ans, map);
                    seq.remove(seq.size() - 1);
                }
            }
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // Step 1) Perform word ladder 1 and store the words with the level in map
        HashMap<String, Integer> map = new HashMap<>();

        HashSet<String> hs = new HashSet<>();
        for (String s : wordList) {
            hs.add(s);
        }

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        map.put(beginWord, 0);

        while (!q.isEmpty()) {
            String word = q.poll();

            int steps = map.get(word);
            for (int j = 0; j < word.length(); j++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char[] arr = word.toCharArray();
                    arr[j] = c;
                    String str = new String(arr);

                    if (hs.contains(str)) {
                        hs.remove(str);
                        map.put(str, steps + 1);
                        q.add(str);
                    }
                }    
            }
        }

        // Step 2) Backtrack using map from end to begin
        List<List<String>> ans = new ArrayList<>();

        // Only perform if we have reached the endword
        if (map.containsKey(endWord)) {
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, beginWord, seq, ans, map);
        }

        return ans;
    }
}
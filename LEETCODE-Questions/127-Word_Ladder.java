class Pair{
    String s;
    int len;

    public Pair(String _s, int _len){
        this.s = _s;
        this.len = _len;
    }
}

class Solution {
    // TC: O(N * (word.length * 26))
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs = new HashSet<>();
        for(int i=0; i<wordList.size(); i++){
            hs.add(wordList.get(i));   
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        while(!q.isEmpty()){
            Pair rem = q.poll();
            String str = rem.s;
            int len = rem.len;

            if(str.equals(endWord)){
                return len;
            }

            for(int i = 0; i<str.length(); i++){
                for(char c = 'a'; c <= 'z'; c++){
                    char[] arr = str.toCharArray();
                    arr[i] = c;
                    String newStr = new String(arr);

                    if(hs.contains(newStr)){
                        hs.remove(newStr);
                        q.add(new Pair(newStr, len + 1));
                    }
                }
            }
        }

        return 0;
    }
}
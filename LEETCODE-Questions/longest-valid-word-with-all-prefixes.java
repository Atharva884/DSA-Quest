class Node{
    char ch;
    HashMap<Character, Node> map;
    boolean eow;
    
    public Node(char _ch){
        this.ch = _ch;
        this.map = new HashMap<>();
        this.eow = false;
    }
}

class Solution {
    // TC: O(N*L), SC: O(N*26)
    public void insert(String s, Node root){
        Node t = root;
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(t.map.containsKey(ch)){
                t = t.map.get(ch);
            }else{
                Node newNode = new Node(ch);
                t.map.put(ch, newNode);
                t = t.map.get(ch);
            }
        }
        
        t.eow = true;
    }
    
    // TC: O(N*L)
    public boolean search(String s, Node root){
        Node t = root;
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(t.map.containsKey(ch)){
                t = t.map.get(ch);
            }else{
                return false;
            }
            
            if(!t.eow) return false;
        }
        
        return true;
    }
    
    // TC: O(N*L) + O(N*L) * O(L) -> worst case if lengths are equal ~ O(2N*L), SC: O(N*L*26)
    public String longestValidWord(String[] words) {
        int n = words.length;
        List<String> res = new ArrayList<>();
        String ans = "";
        
        Node root = new Node('R');
        for(int i=0; i<n; i++){
            insert(words[i], root);
        }
        
        for(int i=0; i<n; i++){
            if(search(words[i], root)){
                if(words[i].length() == ans.length()){
                    if(words[i].compareTo(ans) < 0){
                        ans = words[i];
                    }
                }else if(words[i].length() > ans.length()){
                    ans = words[i];
                }
            }
        }
 
        return ans;
    }
}

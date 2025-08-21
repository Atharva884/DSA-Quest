class Node{
    char ch;
    HashMap<Character, Node> map;
    boolean eow;
    
    public Node(char _ch){
        this.map = new HashMap<>();
        this.ch = _ch;
        this.eow = false;
    }
}

class Trie {
    Node root;
    public Trie() {
        root = new Node('R');
    }
    
    // TC: O(l) where l is the average length of the word, SC: O(26) for storing
    // characters in the map
    public void insert(String word) {
        Node t = root;
        
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            
            if(t.map.containsKey(c)){
                t = t.map.get(c);
            }else{
                Node newNode = new Node(c);
                t.map.put(c, newNode);
                t = t.map.get(c);
            }
        }
        
        t.eow = true;
    }
    
    // TC: O(l) where l is the average length of the word
    public boolean search(String word) {
        Node t = root;
        
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            
            if(t.map.containsKey(c)){
                t = t.map.get(c);
            }else{
                return false;
            }
        }
        
        return t.eow;
    }

    // TC: O(l) where l is the length of the prefix     
    public boolean startsWith(String prefix) {
        Node t = root;
        
        for(int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            
            if(t.map.containsKey(c)){
                t = t.map.get(c);
            }else{
                return false;
            }
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

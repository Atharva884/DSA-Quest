// User function Template for Java
class Node{
    char ch;
    HashMap<Character, Node> map;
    boolean eow;
    int count;
    
    public Node(char _ch){
        this.ch = _ch;
        this.map = new HashMap<>();
        this.eow = false;
        this.count = 0;
    }
}

class Solution {
    public void insert(String word, Node root){
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
            
            t.count++;
        }
        
        t.eow = true;
    }
    
    public int searchPrefix(String str, int n, Node root){
        Node t = root;
        
        for(int i=0; i<n; i++){
            char c = str.charAt(i);
            
            if(t.map.containsKey(c)){
                t = t.map.get(c);
            }else{
                return 0;
            }
        }
        
        return t.count;
    }
    
    // Optimal Approach
    // TC: O(N*L) + O(K), SC: O(N * L * 26)
    public int klengthpref(String[] arr, int n, int k, String str) {
        int len = str.length();
        if(k > len) return 0;

        Node root = new Node('R');
        
        // Insert all the words into the trie
        // TC: O(N * l) where l is the avg length of word, SC: O(N * 26)
        for(int i=0; i<n; i++){
            insert(arr[i], root);
        }
        
        // Search for prefix in the trie
        // TC: O(k)
        return searchPrefix(str, k, root);
    }
}

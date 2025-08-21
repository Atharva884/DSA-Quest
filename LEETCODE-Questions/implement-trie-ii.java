import java.util.* ;
import java.io.*;

public class Trie {
    static class Node{
        char ch;
        int count;
        HashMap<Character, Node> map;
        boolean eow;
        int word;

        public Node(char _ch){
            this.ch = _ch;
            this.map = new HashMap<>();
            this.count = 0;
            this.eow = false;
            this.word = 0;
        }
    }

    static Node root;
    public Trie() {
        root = new Node('R');
    }

    // TC: O(N*l) where l is the length of the word, SC: O(N * L * 26)
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
            t.count++;
        }

        t.eow = true;
        t.word++;
    }

    // TC: O(N*l) where l is the length of the word
    public int countWordsEqualTo(String word) {
        Node t = root;
        
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            
            if(t.map.containsKey(c)){
                t = t.map.get(c);
            }else{
                return 0;
            }
        }
        
        return t.eow ? t.word : 0;
    }

    // TC: O(N*l) where l is the length of the word
    public int countWordsStartingWith(String word) {
        Node t = root;
        
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            
            if(t.map.containsKey(c)){
                t = t.map.get(c);
            }else{
                return 0;
            }
        }
        
        return t.count;
    }

    // TC: O(N*l) where l is the length of the word
    public void erase(String word) {
        Node t = root;
        int n = word.length();
        
        int i = 0;
        while(i < n){
            char c = word.charAt(i);
            Node temp = t.map.get(c);
            temp.count--;

            t = temp;

            i++;
        }
        t.word--;
    }

}

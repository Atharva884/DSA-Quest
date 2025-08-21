import java.util.ArrayList;
import java.util.*;

public class Solution 
{
	public static class Node{
		char ch;
		HashMap<Character, Node> map;
		boolean eow;

		public Node(char _ch){
			this.ch = _ch;
			this.map = new HashMap<>();
			this.eow = false;
		}
	}

	public static boolean insert(String s, Node root){
		Node t = root;

		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);

			if(t.map.containsKey(c)){
				t = t.map.get(c);
			}else{
				Node newNode = new Node(c);
				t.map.put(c, newNode);
				t = t.map.get(c);
			}
		}

		boolean ans = t.eow;
		t.eow = true;

		return ans;
	}

	// Brute Approach
	// TC: O(N^2), SC: O(N^2) in worst case
	// For eg: if all the substrings generated are distinct, then we will store 
	// n^2 substrings in the map, and each string will have average length so
	// n^2 * n/2 => nearly (n^3), So its very huge
	// So we can space optimized the approach, i.e using Trie or string hashing

	// Optimal Approach
	// TC: O(N^2 * (L)) -> where l is length of the word, SC: O(N*L*26)
	public static int countDistinctSubstrings(String s) 
	{
		int n = s.length();

		Node root = new Node('R');
		int ans = 0;

		for(int sp=0; sp<n; sp++){
			StringBuilder sb = new StringBuilder();
			for(int ep=sp; ep<n; ep++){
				sb.append(s.charAt(ep));
				if(!insert(sb.toString(), root)) ans++;
			}
		}

		return ans + 1;
	}
}

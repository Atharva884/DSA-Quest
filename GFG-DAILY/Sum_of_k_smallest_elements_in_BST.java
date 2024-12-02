//User function Template for Java

/*
class Node {
    int data;
    Node left, right;
    Node(int key){
        this.data = key;
        this.left = this.right = null;
    }
}
*/

class Tree {
    int total;
    int idx;
        
    void solve(Node root, int k){
        if(root == null){
            return;
        }
        
        solve(root.left, k);
        
        idx++;
        if(idx <= k){
            total += root.data;
        }
        
        solve(root.right, k);
    }
    
    int sum(Node root, int k) { 
        total = 0;
        idx = 0;
        solve(root, k);
        
        return total;
    } 
}
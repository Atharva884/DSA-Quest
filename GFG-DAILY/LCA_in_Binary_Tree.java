/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/

class Solution {
    
    Node solve(Node root, int n1, int n2){
        if(root == null){
            return null;
        }
        
        if(root.data == n1 || root.data == n2){
            return root;
        }
       
        
        Node l = solve(root.left, n1, n2);
        
        Node r = solve(root.right, n1, n2);
        
        // We have found our answer
        if(l != null && r != null){
            return root;
        }
        
        // We are returning non-null nodes
        if(l != null){
            return l;
        }
        
        if(r != null){
            return r;
        }
        
        return null;
    }
    
    Node lca(Node root, int n1, int n2) {
        return solve(root, n1, n2);
    }
}

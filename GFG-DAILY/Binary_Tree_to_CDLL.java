//User function Template for Java



//User function Template for Java
/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Solution
{ 
    // TC: O(1)
    public static Node concatenate(Node h1, Node h2){
        Node t1 = h1.left;
        Node t2 = h2.left;
        
        t1.right = h2;
        h2.left = t1;
        t2.right = h1;
        h1.left = t2;
        
        return h1;
    }
    
    // TC: O(N), SC: O(H) -> where H denotes the stack space of recursion
    public static Node solve(Node root){
        if(root == null){
            return null;
        }
        
        Node l = solve(root.left);
        Node r = solve(root.right);
        
        // Making the root, circular linked list
        root.right = root.left = root;
        if(l == null && r == null){
            return root;
        }else if(l == null && r != null){
            concatenate(root, r);
            return root;
        }else if(l != null && r == null){
            concatenate(l, root);
            return l;
        }else{
            // if both are not null
            concatenate(root, r);
            concatenate(l, root);
            
            return l;
        }
    }
    
    Node bTreeToClist(Node root)
    {
        if(root == null){
            return root;
        }
        
        return solve(root);
    }
    
}
    

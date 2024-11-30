// User function Template for Java

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
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(root == null){
            return ans;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(q.size() != 0){
            int size = q.size();
            
            for(int i=0; i<size; i++){
                Node rem = q.poll();
                
                if(i == 0){
                    ans.add(rem.data);
                }
                
                if(rem.left != null){
                    q.add(rem.left);
                }
                
                if(rem.right != null){
                    q.add(rem.right);
                }
            }
        }
        
        return ans;
    }
}
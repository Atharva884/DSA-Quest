//User function Template for Java

/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution
{
    //Function to return the level order traversal of a tree.
    static ArrayList<Integer> levelOrder(Node root) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(root == null){
            return ans;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(q.size() != 0){
            Node rem = q.poll();
            
            ans.add(rem.data);
            
            if(rem.left != null){
                q.add(rem.left);
            }
            
            if(rem.right != null){
                q.add(rem.right);
            }
        }
        
        return ans;
    }
}






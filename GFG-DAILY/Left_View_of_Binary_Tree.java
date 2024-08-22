//User function Template for Java

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
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> arr = new ArrayList<>();
        
      if(root == null) return arr;
      
      Queue<Node> q = new LinkedList<>();
      
      q.add(root);
      
      while(q.size() > 0){
          int size = q.size();
          
          for(int i=0; i<size; i++){
              Node rem = q.poll();
              
              if(i == 0){
                  arr.add(rem.data);
              }
              
              if(rem.left != null){
                  q.offer(rem.left);
              }
              
              if(rem.right != null){
                  q.offer(rem.right);
              }
          }
      }
      
      return arr;
    }
}
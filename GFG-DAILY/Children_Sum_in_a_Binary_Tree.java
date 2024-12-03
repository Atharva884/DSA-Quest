//User function Template for Java


/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	
	Node(int key)
	{
	    data = key;
	    left = right = null;
	}
}

*/
class Solution
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(q.size() != 0){
            int size = q.size();
            
            boolean isSatisfied = true;
            for(int i=0; i<size; i++){
                Node rem = q.poll();
                
                int sum = 0;
                if(rem.left != null){
                    sum += rem.left.data;
                    q.add(rem.left);
                }
                
                if(rem.right != null){
                    sum += rem.right.data;
                    q.add(rem.right);
                }
                
                if(sum != rem.data && sum != 0){
                    isSatisfied = false;
                    break;
                }
            }
            
            if(isSatisfied == false){
                return 0;
            }
        }
        
        return 1;
    }
}
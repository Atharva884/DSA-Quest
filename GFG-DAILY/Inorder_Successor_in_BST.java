//User function Template for Java

/*Complete the function below
Node is as follows:
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
    // Brute Force Approach
    // TC: O(N), SC: O(N)
    public void solve(Node root, ArrayList<Node> arr){
        if(root == null){
            return;
        }
        
        solve(root.left, arr);
        arr.add(root);
        solve(root.right, arr);
    }
    
	public Node inorderSuccessor(Node root, Node x){
        ArrayList<Node> arr = new ArrayList<>();
        solve(root, arr);
        
        for(int i=0; i<arr.size(); i++){
            if(arr.get(i).data == x.data){
                if(i+1 < arr.size()){
                    return arr.get(i+1);
                }
            }
        }
        
        return null;
    }
}
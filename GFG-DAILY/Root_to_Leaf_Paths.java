/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static void solve(Node root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ans){
        if(root == null){
            return;
        }
        
        path.add(root.data);
        
        // It's a leaf node
        if(root.left == null && root.right == null){
            ans.add(new ArrayList<>(path));
        }
                
        solve(root.left, path, ans);
        solve(root.right, path, ans);
        
        path.remove(path.size() - 1);
    }
    
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        
        solve(root, path, ans);
        
        return ans;
    }
}
        

/*class Node of the binary tree
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}*/
class Solution {
    
    public void solve(Node root, ArrayList<Integer> ans, ArrayList<Integer> newArr, int target){
        if(root == null){
            return;
        }
        
        ans.add(root.data);
        
        if(root.data == target){
            ans.remove(ans.size() - 1);
            for(int i=ans.size()-1; i>=0; i--){
                newArr.add(ans.get(i));
            }
            return;
        }
        
        solve(root.left, ans, newArr, target);
        solve(root.right, ans, newArr, target);
        
        
        ans.remove(ans.size() - 1);
    }

    public ArrayList<Integer> Ancestors(Node root, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> newArr = new ArrayList<>();
        
        solve(root, ans, newArr, target);
        
        return newArr;
    }
}
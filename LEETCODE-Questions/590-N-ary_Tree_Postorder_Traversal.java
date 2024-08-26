/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public static void solve(Node root, List<Integer> arr){
        if(root == null) return;

        List<Node> childrens = root.children;
        for(int i=0; i<childrens.size(); i++){
            solve(childrens.get(i), arr);
        }
        arr.add(root.val);
    }

    public List<Integer> postorder(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        solve(root, arr);

        return arr;
    }
}
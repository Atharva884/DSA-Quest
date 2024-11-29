/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Brute Force
// TC: O(N), SC: O(1)

// class BSTIterator {
//     ArrayList<Integer> arr;
//     int tmp;

//     public void inOrder(TreeNode root, ArrayList<Integer> arr){
//         if(root == null){
//             return;
//         }

//         inOrder(root.left, arr);
//         arr.add(root.val);
//         inOrder(root.right, arr);
//     }

//     public BSTIterator(TreeNode root) {
//         arr = new ArrayList<>();
//         inOrder(root, arr); 
//         tmp = -1;     
//     }
    
//     public int next() {
//         tmp++;
//         if(tmp < arr.size()){
//             return arr.get(tmp);
//         }

//         return -1;
//     }
    
//     public boolean hasNext() {
//         if(tmp + 1 < arr.size()){
//             return true;
//         }

//         return false;
//     }
// }

// Optimal Approach
// TC: O(1) on average, SC: O(H) 
class BSTIterator {
    Stack<TreeNode> st;
    public void pushAll(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        pushAll(root); 
    }
    
    public int next() {
        TreeNode rem = st.pop();
        pushAll(rem.right);
        return rem.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
**/
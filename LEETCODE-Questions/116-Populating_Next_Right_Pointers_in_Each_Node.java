/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    // Brute Force Approach
    // TC: O(N), SC: O(N)

    // public Node connect(Node root) {
    //     if(root == null){
    //         return null;
    //     }

    //     Queue<Node> q = new LinkedList();
    //     q.add(root);

    //     while(q.size() != 0){
    //         int size = q.size();

    //         for(int i=0; i<size; i++){
    //             Node rem = q.poll();
    //             Node peek = q.peek();

    //             if(i < size-1){
    //                 rem.next = peek;
    //             }

    //             if(rem.left != null){
    //                 q.add(rem.left);
    //             }

    //             if(rem.right != null){
    //                 q.add(rem.right);
    //             }
    //         }
    //     }

    //     return root;
    // }

    public Node connect(Node root){
        Node cur = root;

        if(root == null){
            return null;
        }

        while(root.left != null){
            Node tmp = root;

            while(tmp != null){
                tmp.left.next = tmp.right;
                if(tmp.next != null){
                    tmp.right.next = tmp.next.left;
                }

                tmp = tmp.next;
            }

            root = root.left;
        }

        return cur;
    }
}
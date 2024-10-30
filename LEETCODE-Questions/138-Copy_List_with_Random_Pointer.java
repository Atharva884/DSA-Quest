/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    // Brute Force Approach
    // TC: O(N), SC: O(N)

    // public static Node copyRandomList(Node head) {
    //     if(head == null){
    //         return null;
    //     }

    //     HashMap<Node, Node> map = new HashMap<>();
    //     Node temp = head;

    //     Node cur = new Node(-1);
    //     Node ans = cur;
    //     Node head1 = cur;

    //     while(temp != null){
    //         Node newNode = new Node(temp.val);
    //         cur.next = newNode;

    //         map.put(temp, newNode);

    //         cur = cur.next;
    //         temp = temp.next;
    //     }

    //     ans = ans.next;
    //     temp = head;

    //     while(temp != null){
    //         if(temp.random != null){
    //             Node ran = temp.random;
    //             ans.random = map.get(ran);
    //         }

    //         ans = ans.next;
    //         temp = temp.next;
    //     }

    //     return head1.next;
    // }

    // Optimal Approach
    // TC: O(N), SC: O(1)

    public static Node copyRandomList(Node head){
        // Step 1
        // Insertion

        if(head == null){
            return null;
        }

        Node temp = head;

        while(temp != null){
            Node newNode = new Node(temp.val);
            Node p1 = temp.next;
            temp.next = newNode;
            newNode.next = p1;

            temp = temp.next.next;
        }

        // Step 2)
        // Setting the random pointers
        temp = head;

        while(temp != null){
            if(temp.random != null){
                temp.next.random = temp.random.next;
            }

            temp = temp.next.next;
        }

        // Step 3)
        // Segretate the original and duplicate

        // Storing head is mandatory, bcoz we are then segregating the linked
        // list
        Node ans = head.next;

        Node h1 = head;
        Node h2 = head.next;

        while(h1 != null){
            Node p1 = h1.next.next;
            Node p2 = null;
            if(h2.next != null){
                p2 = h2.next.next;
            }

            h1.next = p1;
            h2.next = p2;

            h1 = h1.next;
            h2 = h2.next;
        }


        return ans;
    }
}
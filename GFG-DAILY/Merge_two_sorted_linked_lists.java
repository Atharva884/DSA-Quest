/*
  Merge two linked lists
  head pointer input could be NULL as well for empty list
  Node is defined as
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Solution {
    // Function to merge two sorted linked list.
    public Node mergeTwoSortedLL(Node list1, Node list2){
        if(list1 == null && list2 == null){
            return null;
        }
        
        Node temp = new Node(-1);
        Node head = temp;

        Node l1 = list1;
        Node l2 = list2;
        Node k = temp;

        while(l1 != null && l2 != null){
            if(l1.data <= l2.data){
                Node newNode = new Node(l1.data);
                k.next = newNode;

                k = k.next;
                l1 = l1.next;
            }else{
                Node newNode = new Node(l2.data);
                k.next = newNode;

                k = k.next;
                l2 = l2.next;
            }
        }

        // If list2 becomes null
        while(l1 != null){
            Node newNode = new Node(l1.data);
            k.next = newNode;

            k = k.next;
            l1 = l1.next;
        }

        // If list1 becomes null
        while(l2 != null){
            Node newNode = new Node(l2.data);
            k.next = newNode;
            
            k = k.next;
            l2 = l2.next;
        }

        return head.next;
    }
    
    Node sortedMerge(Node head1, Node head2) {
        return mergeTwoSortedLL(head1, head2);
    }
}

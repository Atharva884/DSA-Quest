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
    
    // Brute Force Approach
    // TC: O(N+M), SC: O(N+M)
    
    // public Node mergeTwoSortedLL(Node list1, Node list2){
    //     if(list1 == null && list2 == null){
    //         return null;
    //     }
        
    //     Node temp = new Node(-1);
    //     Node head = temp;

    //     Node l1 = list1;
    //     Node l2 = list2;
    //     Node k = temp;

    //     while(l1 != null && l2 != null){
    //         if(l1.data <= l2.data){
    //             Node newNode = new Node(l1.data);
    //             k.next = newNode;

    //             k = k.next;
    //             l1 = l1.next;
    //         }else{
    //             Node newNode = new Node(l2.data);
    //             k.next = newNode;

    //             k = k.next;
    //             l2 = l2.next;
    //         }
    //     }

    //     // If list2 becomes null
    //     while(l1 != null){
    //         Node newNode = new Node(l1.data);
    //         k.next = newNode;

    //         k = k.next;
    //         l1 = l1.next;
    //     }

    //     // If list1 becomes null
    //     while(l2 != null){
    //         Node newNode = new Node(l2.data);
    //         k.next = newNode;
            
    //         k = k.next;
    //         l2 = l2.next;
    //     }

    //     return head.next;
    // }
    
    // Node sortedMerge(Node head1, Node head2) {
    //     return mergeTwoSortedLL(head1, head2);
    // }
    
    // Optimal Approach
    // TC: O(N+M), SC: O(1)
    
    public Node mergeTwoSortedLL(Node list1, Node list2){
        Node ans = null;  // As we need to return the head of modified ll
        Node t = null;    // It is used for changing the pointer of the prev nodes
        
        Node h1 = list1;
        Node h2 = list2;
        
        if(h1.data < h2.data){
            ans = h1;
            t = h1;
            h1 = h1.next;      // Why h1.next? => h1 and h2 are just used for comparison
        }else{
            ans = h2;
            t = h2;
            h2 = h2.next;
        }
        
        while(h1 != null && h2 != null){
            if(h1.data < h2.data){
                t.next = h1;
                t = t.next;
                
                // Moving h1 forward for comparison
                h1 = h1.next;
            }else{
                t.next = h2;
                t = t.next;
                
                // Moving h2 forward for comparison
                h2 = h2.next;
            }
        }
        
        // If any of the linkedlist becomes null
        if(h1 != null){
            t.next = h1;
        }
        
        if(h2 != null){
            t.next = h2;
        }
        
        return ans;
    }
    
    Node sortedMerge(Node head1, Node head2){
        return mergeTwoSortedLL(head1, head2);
    }
    
}

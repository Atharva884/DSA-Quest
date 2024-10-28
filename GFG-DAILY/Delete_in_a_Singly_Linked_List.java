/* Linklist node structure
class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/
class Solution {
    // Not Efficient
    // TC: O(2N) ~ O(N), SC: O(1)
    
    // Node deleteNode(Node head, int x) {
    //     if(x == 1){
    //         head = head.next;
    //         return head;
    //     }
        
    //     Node temp = head;
    //     while(temp != null && x != 1){
    //         temp = temp.next;
    //         x--;
    //     }
        
    //     Node temp1 = head;
        
    //     while(temp1 != null && temp1.next != temp){
    //         temp1 = temp1.next;
    //     }
        
    //     temp1.next = temp.next;
        
    //     return head;
    // }
    
    
    // Efficient 
    // TC: O(N), SC: O(1)
    Node deleteNode(Node head, int x){
        // If the x is 1 means its a head node
        if(x == 1){
            return head.next;
        }
        
        Node temp = head;
        for (int i = 1; i < x - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            return head;
        }
  
        temp.next = temp.next.next;
        
        return head;
    }
}
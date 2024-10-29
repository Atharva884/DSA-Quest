/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}*/

class Solution {
    // Function to insert a new node at given position in doubly linked list.
    Node addNode(Node head, int p, int x) {
        if(p == 0){
            Node p1 = head.next;
            
            Node newNode = new Node(x);
            head.next = newNode;
            newNode.prev = head;
            newNode.next = p1;
            p1.prev = newNode;
            
            return head;
        }
        
        Node temp = head;
        
        for(int i=0; i < p && temp != null; i++){
            temp = temp.next;
        }
        
        Node newNode = new Node(x);
        if(temp.next == null){
            temp.next = newNode;
            newNode.prev = temp;
        }else{
            Node p1 = temp.next;
            newNode.next = p1;
            p1.prev = newNode;
            temp.next = newNode;
            newNode.prev = temp;
        }
        
        return head;
    }
}
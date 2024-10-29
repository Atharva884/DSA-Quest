/*
Definition for doubly Link List Node
class Node {
    int data;
    Node next;
    Node prev;

    Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node deleteNode(Node head, int x) {
        if(x == 1){
            head = head.next;
            head.prev = null;
            return head;
        }
        
        Node temp = head;
        
        for(int i=1; i < x-1 && temp != null; i++){
            temp = temp.next;
        }
    
        
        if(temp.next.next != null){
            Node p1 = temp.next.next;
            temp.next = p1;
            p1.prev = temp;
        }else{
            temp.next = null;
        }
        
        return head;
    }
}

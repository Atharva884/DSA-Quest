//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/



/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public static Node reverseLL(Node head){
        Node cur = head;
        Node prev = null;
        
        while(cur != null){
            Node curP1 = cur.next;
            cur.next = prev;
            
            // Prep for next node reversal
            prev = cur;
            cur = curP1;
        }
        
        head = prev;
        
        return head;
    }
    
    public Node addOne(Node head) {
        Node reverseHead1 = reverseLL(head);
        
        // We need to add the 1
        int carry = 1;
        
        Node temp = reverseHead1;
        
        while(temp != null){
            
            temp.data += carry;
            
            if(temp.data < 10){
                // Means ther is no carry
                carry = 0;
                break;
            }else{
                // There is carry
                temp.data = 0;
                carry = 1;
            }
            
            temp = temp.next;
        }
        
        Node reverseHead2 = reverseLL(reverseHead1);
        
        // Check if the carry is 1
        if(carry == 1){
            Node dummy = new Node(1);
            dummy.next = reverseHead2;
            
            return dummy;
        }
        
        
        return reverseHead2;
    }
}

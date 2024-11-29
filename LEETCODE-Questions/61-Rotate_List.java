/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int sizeOfLL(ListNode head){
        int size = 0;

        while(head != null){
            size++;
            head = head.next;
        }

        return size;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }

        ListNode temp = head;

        int n = sizeOfLL(head);
        int rem = k % n;

        if(rem == 0){
            return temp;
        }

        int i=1;
        while(temp != null && i < n - rem){
            temp = temp.next;
            i++;
        }

        if(temp == null || temp.next == null){
            return temp;
        }

        ListNode p1 = temp.next;
        ListNode ans = p1;

        temp.next = null;

        while(p1 != null && p1.next != null){
            p1 = p1.next;
        }
    
        if(p1 != null){
            p1.next = head;
        }

        return ans;
    }
}
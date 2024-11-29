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
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }

        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();
        ListNode t1 = dummy1;
        ListNode t2 = dummy2;

        ListNode temp = head;
        while(temp != null){
            ListNode n1 = new ListNode(temp.val);
            if(temp.val >= x){
                t2.next = n1;
                t2 = t2.next;
            }else{
                t1.next = n1;
                t1 = t1.next;
            }

            temp = temp.next;
        }

        t1.next = dummy2.next;

        return dummy1.next;
    }
}
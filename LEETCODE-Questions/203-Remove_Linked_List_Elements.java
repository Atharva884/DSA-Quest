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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode temp = dummy;
        while(temp != null){
            while(temp.next != null && temp.next.val == val){
                if(temp.next.next != null){
                    ListNode p1 = temp.next.next;
                    temp.next = p1;
                }else{
                    temp.next = null;
                }
            }

            temp = temp.next;
        }

        if(head.next == null && head.val == val){
            return null;
        }

        return dummy.next;
    }
}
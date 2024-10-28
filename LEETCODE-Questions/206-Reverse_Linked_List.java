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
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode prev = null;
        ListNode temp = head;

        while(temp != null){
            ListNode q = temp.next;
            temp.next = prev;
            prev = temp;
            temp = q;
        }

        head = prev;

        return head;
    }
}
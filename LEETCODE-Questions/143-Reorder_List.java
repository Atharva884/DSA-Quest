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
    // public ListNode makeLL(ListNode head){
    //     ListNode temp = head;
    //     ListNode dummy = new ListNode(-1);
    //     ListNode head1 = dummy;

    //     while(temp != null){
    //         ListNode newNode = new ListNode(temp.val);
    //         dummy.next = newNode;

    //         dummy = dummy.next;
    //         temp = temp.next;
    //     }

    //     dummy.next = null;
        
    //     return head1.next;
    // }

    public ListNode reverseLL(ListNode head) {
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

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverseLL(slow);
        slow.next = null;

        ListNode original = head;
        ListNode reversed = secondHalf;

        while (original != null && reversed != null) {
            ListNode ogP1 = original.next;
            ListNode reP1 = reversed.next;

            original.next = reversed;
            reversed.next = ogP1;

            original = ogP1;
            reversed = reP1;
        }
    }
}

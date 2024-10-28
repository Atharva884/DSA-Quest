/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode temp = head;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow =  slow.next;
            fast = fast.next.next;

            if(slow == fast){
                break;
            }
        }

        if(fast == null || fast.next == null){
            // There is no cycle
            return null;
        }

        fast = temp;

        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}